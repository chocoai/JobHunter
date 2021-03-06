package org.codingwater.serviceimpl;

import org.codingwater.BaseTest;
import org.codingwater.model.LagouJobInfo;
import org.codingwater.model.NeituiJobInfo;
import org.codingwater.service.IJobSpiderService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.List;


/**
 * Created by water on 4/19/16.
 */
public class JobSpiderServiceImplTest extends BaseTest{

  @Autowired
  private IJobSpiderService jobSpiderService;

  @Test
  public void testFetchJobInfosFromLagou() throws Exception {
    List<LagouJobInfo> ret = jobSpiderService.fetchJobInfosFromLagou("上海", "Java", 1, "10k-15k", "");
    Assert.assertNotEquals(0, ret.size());

  }


  @Test
  public void testFetchJobInfosFromNeitui() {
    List<NeituiJobInfo> ret =
        jobSpiderService.fetchJobInfosFromNeitui("上海", "Java", 1, "5-10", "2");
    Assert.assertNotEquals(0, ret.size());

  }

  @Test
  public void testCalendar() {

    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);
    //获取今日凌晨时间戳
    System.out.println(cal.getTimeInMillis());

    //获取昨日凌晨时间戳
    cal.add(Calendar.DATE, -1);
    System.out.println(cal.getTimeInMillis());
  }


  @Test
  public void testFetchYesterdayDataFromLagou() {

    jobSpiderService.fetchYesterdayDataFromLagou("Java");
    System.out.println("__________________________");
    jobSpiderService.fetchYesterdayDataFromLagou("Python");
    System.out.println("__________________________");
    jobSpiderService.fetchYesterdayDataFromLagou("PHP");
    System.out.println("__________________________");
    jobSpiderService.fetchYesterdayDataFromLagou("测试");
  }




  //从neitui爬去数据
  @Test
  public void testFetchAndSaveDataFromNeitui() {

    jobSpiderService.fetchAndSaveDataFromNeitui("Java");
    System.out.println("_____________________________________");
    jobSpiderService.fetchAndSaveDataFromNeitui("Python");
    System.out.println("_____________________________________");
    jobSpiderService.fetchAndSaveDataFromNeitui("PHP");
    System.out.println("_____________________________________");
    jobSpiderService.fetchAndSaveDataFromNeitui("测试");
  }


  @Test
  public void testMultiFetch() throws InterruptedException {

    jobSpiderService.multiThreadFetch("php");

//    Thread.sleep(500000);//sleep 100s

  }
}