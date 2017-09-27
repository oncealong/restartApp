# restartApp
How to restart android app programmatically? Look here!

当App遇到严重问题，不得不关闭时，相比系统弹框，App弹框询问用户是关闭还是重启有更好的体验！
那么Android下App如何重启呢？
这里尝试了三种重启方法：
1.PendingIntent和AlarmManager
2.Intent.makeRestartActivityTask
3.JobScheduler和Intent

没有做兼容性测试，但是在三星S6 Edge和荣耀X6上，这三种都是可以工作的。
如果您发现在某种机型上无法重启，欢迎反馈。


参考文献:
===============
https://stackoverflow.com/questions/6609414/how-do-i-programmatically-restart-an-android-app
