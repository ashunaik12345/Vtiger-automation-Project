package vtiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImpemenatation implements IRetryAnalyzer{

	int count=0;
	int retryCount=3;
	/**
	 * Retry until retry count is met
	 */
	
	public boolean retry(ITestResult result) {
		while(count<retryCount) {
			count++;
			return true;
		}
		return false;
	}
}
