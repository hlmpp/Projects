package org.javaboy.vhr.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * FilterSecurityInterceptor会调用 AccessDecisionManager 进行授权决策，若决策通过，则允许访问资
 * 源，否则将禁止访问。通过传递的参数来决定用户是否有访问对应受保护资源的权限。
 * AccessDecisionManager采用投票的方式来确定是否能够访问受保护资源。
 *
 * Spring security默认使用的是AffirmativeBased。
 * （1）只要有AccessDecisionVoter的投票为ACCESS_GRANTED则同意用户进行访问；
 * （2）如果全部弃权也表示通过；
 * （3）如果没有一个人投赞成票，但是有人投反对票，则将抛出AccessDeniedException。
 */
@Component
public class CustomUrlDecisionManager implements AccessDecisionManager {

    /**
     * 第一个参数中保存了当前登录用户的角色信息，
     * 第三个参数则是CustomFilterInvocationSecurityMetadataSource中的getAttributes方法传来的，
     * 表示当前请求需要的角色（可能有多个）
     */
    @Override
    public void decide(Authentication authentication, Object object,
                       Collection<ConfigAttribute> configAttributes)
            throws AccessDeniedException, InsufficientAuthenticationException {

        for (ConfigAttribute configAttribute : configAttributes) {
            //当前请求需要的权限
            String needRole = configAttribute.getAttribute();
            if ("ROLE_LOGIN".equals(needRole)) {
                if (authentication instanceof AnonymousAuthenticationToken) {
                    throw new AccessDeniedException("尚未登录，请登录!");
                } else {
                    return;
                }
            }
            //当前用户所具有的权限
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals(needRole)) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足，请联系管理员!");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
