package retryattempts;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer{
	int counterForRetryAttempts=0;
	int setMaxLimit=3;
	@Override
	public boolean retry(ITestResult result) {
		if(!result.isSuccess()) {
			if(counterForRetryAttempts<setMaxLimit) {
				counterForRetryAttempts++;
				return true;
			}
		}
		return false;
	}

}
