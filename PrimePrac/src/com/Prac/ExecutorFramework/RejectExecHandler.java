package com.Prac.ExecutorFramework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectExecHandler implements RejectedExecutionHandler
{
    private List<Runnable> rejectedTaskList;

    RejectExecHandler()
    {
        rejectedTaskList = new ArrayList<>();
    }

    public List<Runnable> getRejectedTaskList()
    {
        return rejectedTaskList;
    }

    @Override
    public void rejectedExecution( Runnable r,
                                   ThreadPoolExecutor executor )
    {
        System.out.println( "Task rejected : " + ( (DemoTask) r ).getName() );
        System.out.println( "Adding to rejected task list .." );
        rejectedTaskList.add( (DemoTask) r );
    }

}
