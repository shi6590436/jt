package com.net.jianshu.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class TeskTask  {

//    @Scheduled(fixedRate=2000)
    public void  teskTask() throws Exception{
        Thread.sleep(3000);
        System.out.println("执行定时任务："+new Date());
    }
//    @Scheduled(fixedDelay=2000)
    public void  teskTask1() throws Exception{
        Thread.sleep(3000);
        System.out.println("执行定时任务："+new Date());
    }

        @Scheduled(cron="0 27 09 * * ?")
    public void  teskTask2() throws Exception{
        Thread.sleep(3000);
        System.out.println("执行定时任务："+new Date());
    }
//    使用方式 :
//    crontab file [-u user]-用指定的文件替代目前的crontab。
//    crontab-[-u user]-用标准输入替代目前的crontab.
//            crontab-1[user]-列出用户目前的crontab.
//            crontab-e[user]-编辑用户目前的crontab.
//            crontab-d[user]-删除用户目前的crontab.
//            crontab-c dir- 指定crontab的目录。
//    crontab文件的格式：M H D m d cmd.
//
//            =========================
//
//    关于cronExpression表达式：
//    字段 允许值 允许的特殊字符
//    秒 0-59 , - * /
//    分 0-59 , - * /
//    小时 0-23 , - * /
//    日期 1-31 , - * ? / L W C
//    月份 1-12 或者 JAN-DEC , - * /
//    星期 1-7 或者 SUN-SAT , - * ? / L C #
//    年（可选） 留空, 1970-2099 , - * /
//    表达式意义
//      "0 0 12 * * ?" 每天中午12点触发
//      "0 15 10 ? * *" 每天上午10:15触发
//      "0 15 10 * * ?" 每天上午10:15触发
//        "0 15 10 * * ? *" 每天上午10:15触发
//        "0 15 10 * * ? 2005" 2005年的每天上午10:15触发
//        "0 * 14 * * ?" 在每天下午2点到下午2:59期间的每1分钟触发
//        "0 0/5 14 * * ?" 在每天下午2点到下午2:55期间的每5分钟触发
//        "0 0/5 14,18 * * ?" 在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发
//        "0 0-5 14 * * ?" 在每天下午2点到下午2:05期间的每1分钟触发
//        "0 10,44 14 ? 3 WED" 每年三月的星期三的下午2:10和2:44触发
//        "0 15 10 ? * MON-FRI" 周一至周五的上午10:15触发
//        "0 15 10 15 * ?" 每月15日上午10:15触发
//        "0 15 10 L * ?" 每月最后一日的上午10:15触发
//        "0 15 10 ? * 6L" 每月的最后一个星期五上午10:15触发
//        "0 15 10 ? * 6L 2002-2005" 2002年至2005年的每月的最后一个星期五上午10:15触发
//        "0 15 10 ? * 6#3" 每月的第三个星期五上午10:15触发
//                    每天早上6点
//        0 6 * * *
//            每两个小时
//        0 */2 * * *
//            晚上11点到早上8点之间每两个小时，早上八点
//        0 23-7/2，8 * * *
//            每个月的4号和每个礼拜的礼拜一到礼拜三的早上11点
//        0 11 4 * 1-3
//                1月1日早上4点
//        0 4 1 1 *
//        =============================================
//    一些crontab的使用例子：
//
//            30 21 * * * /usr/local/etc/rc.d/lighttpd restart
//    上面的例子表示每晚的21:30重启apache。
//
//            45 4 1,10,22 * * /usr/local/etc/rc.d/lighttpd restart
//    上面的例子表示每月1、10、22日的4 : 45重启apache。
//
//            10 1 * * 6,0 /usr/local/etc/rc.d/lighttpd restart
//    上面的例子表示每周六、周日的1 : 10重启apache。
//
//            0,30 18-23 * * * /usr/local/etc/rc.d/lighttpd restart
//    上面的例子表示在每天18 : 00至23 : 00之间每隔30分钟重启apache。
//
//            0 23 * * 6 /usr/local/etc/rc.d/lighttpd restart
//    上面的例子表示每星期六的11 : 00 pm重启apache。
//
//            * */1 * * * /usr/local/etc/rc.d/lighttpd restart
//    每一小时重启apache
//
//* 23-7/1 * * * /usr/local/etc/rc.d/lighttpd restart
//    晚上11点到早上7点之间，每隔一小时重启apache
//
//0 11 4 * mon-wed /usr/local/etc/rc.d/lighttpd restart
//    每月的4号与每周一到周三的11点重启apache
//
//0 4 1 jan * /usr/local/etc/rc.d/lighttpd restart
//    一月一号的4点重启apache


}
