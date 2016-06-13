package com.carinfo.utils;



/**
 * Created by karunamoorthy on 31/5/16.
 */

public interface ServerResult {
    void onTaskSucceeded(int taskID, Object resp);
    void onTaskFailed(int taskID, Object resp);
}
