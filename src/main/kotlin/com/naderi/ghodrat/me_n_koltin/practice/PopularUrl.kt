package com.naderi.ghodrat.me_n_koltin.practice

import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.FileOutputStream
import java.io.InputStreamReader
import java.net.URL
import java.nio.channels.Channels


/*
For this question, you are given a log file from a simple web server. Each line in the log file contains a URL and nothing else. Your job is to write code that will download the log file from the internet, process it, and output the most popular URL in the file. You do not need to normalize the URLs in the log files.

You can find the sample log files at: 

https://public.karat.io/content/q015/urls.txt
https://public.karat.io/content/q015/single_url.txt


Let's say we wanted to extract the top N URLs instead of the single top URL. Can you change your code to make N a configurable parameter?
*/   class PopularUrl

fun main(argv: Array<String>) {
    var fileUrl = URL("https://public.karat.io/content/q015/urls.txt")
    println("fileUrl = ${fileUrl}")
    findTopNPopularUrls(fileUrl, 10)
    println("============================================================================================================================")
    fileUrl = URL("https://public.karat.io/content/q015/single_url.txt")
    println("fileUrl = ${fileUrl}")
    findTopNPopularUrls(fileUrl, 10)

}

private fun findTopNPopularUrls(fileUrl: URL, topN: Int) {
    val urls = ArrayList<String>()
    fileUrl.openStream()
        .use { inp -> BufferedReader(InputStreamReader(inp)).use { bis -> urls.addAll(bis.readLines()) } }
    val eachCountMap = urls.groupingBy { it }.eachCount().toList().sortedByDescending { it.second }.take(topN)
    for ((k, v) in eachCountMap) {
        println("[$k,  $v]")
    }
}
