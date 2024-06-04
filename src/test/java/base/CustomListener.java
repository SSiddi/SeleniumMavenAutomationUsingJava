package base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener extends BaseTest implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("******* Test STARTED *******");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("******* Test PASSED *******");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("******* Test FAILED *******");
		// failed();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("******* Test SKIPPED *******");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("*****Started******");
	}

	@Override
	public void onFinish(ITestContext context) {
	System.out.println("*****Finished******");
	}

}
