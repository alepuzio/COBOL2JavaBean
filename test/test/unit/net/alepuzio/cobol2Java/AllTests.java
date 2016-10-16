package test.unit.net.alepuzio.cobol2Java;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.unit.net.alepuzio.cobol2Java.bean.TestAttr;
import test.unit.net.alepuzio.cobol2Java.bean.TestAttributeSet;
import test.unit.net.alepuzio.cobol2Java.generaFile.input.TestConfigurationTemplateFactoryInputForHost;
import test.unit.net.alepuzio.cobol2Java.generaFile.output.TestConfigurationTemplateFactoryInputFromHost;
import test.unit.net.alepuzio.cobol2Java.generaFile.process.TestGenerateBean;
import test.unit.net.alepuzio.cobol2Java.generaFile.process.TestGenerateXML;

@RunWith(Suite.class)
@SuiteClasses({ TestAttr.class, TestAttributeSet.class,

	TestConfigurationTemplateFactoryInputForHost.class, TestConfigurationTemplateFactoryInputFromHost.class,
	TestGenerateBean.class/*, TestGenerateSuperClass.class*/, TestGenerateXML.class

})
public class AllTests {

}
