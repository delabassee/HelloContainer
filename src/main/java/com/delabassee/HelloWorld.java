package com.delabassee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

public class HelloWorld {

    public static Boolean isRunningInsideDocker() {
        try (Stream< String > stream =
                     Files.lines(Paths.get("/proc/1/cgroup"))) {
            return stream.anyMatch(line -> line.contains("/docker"));
        } catch (IOException e) {
            return false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        int  cpus = Runtime.getRuntime().availableProcessors();
        long mmax = runtime.maxMemory() / 1024 / 1024;
        long mtotal = runtime.totalMemory() / 1024 / 1024;
        int fjSize = ForkJoinPool.commonPool().getPoolSize();
        int fjParellism = ForkJoinPool.commonPool().getCommonPoolParallelism();

        System.out.println("Hello Bordeau, here's what I see.");
        System.out.println("                  Java : " + System.getProperty("java.version"));
        System.out.println("          JVM 'vendor' : " + System.getProperty("java.vendor"));
        System.out.println(" Running inside Docker : " + isRunningInsideDocker());
        System.out.println("           CPU/core(s) : " + cpus);
        System.out.println(" CommonFJP parallelism : " + fjParellism);
        System.out.println("   runtime.maxMemory() : " + mmax + " MB | /!\\ -XX:MaxRAMPercentage=25 ");
        System.out.println("");
    }
}