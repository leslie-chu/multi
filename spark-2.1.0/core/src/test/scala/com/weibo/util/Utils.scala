package com.weibo.util

import java.util.concurrent.ThreadPoolExecutor.{CallerRunsPolicy, AbortPolicy}
import java.util.concurrent.{ArrayBlockingQueue, TimeUnit, ThreadPoolExecutor, LinkedBlockingQueue}

import org.apache.spark.sql._
/**
  * Created by zhenfei1 on 17/7/6.
  */
private[weibo] object Utils {

  def nonNegativeMod(x:Int,mod:Int)={
    val rowMod = x%mod;
    rowMod + (if(rowMod<0) mod else 0)
    val queue = new LinkedBlockingQueue[Integer]()
    new CallerRunsPolicy
    new ThreadPoolExecutor(10,15,5,TimeUnit.SECONDS,new ArrayBlockingQueue[Runnable](10),new AbortPolicy())



  }
}
