package com.axian.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HDFSClient {

    public static void main(String[] args) throws IOException {

        // 1 获取文件系统
        Configuration configuration = new Configuration();
        // 配置在集群上运行
        configuration.set("fs.defaultFS", "hdfs://hadoop101:9000");
        FileSystem fs = FileSystem.get(configuration);

//        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop101:9000"), configuration, "axian");

        // 2 创建目录
        fs.mkdirs(new Path("/1108/daxian/banhua"));

        // 3 关闭资源
        fs.close();
    }


}
