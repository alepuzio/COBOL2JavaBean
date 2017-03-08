package test.unit.net.alepuzio.cobol2java;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.unit.net.alepuzio.cobol2java.bean.TestAttr;
import test.unit.net.alepuzio.cobol2java.bean.TestAttributeSet;
import test.unit.net.alepuzio.cobol2java.generaFile.input.TestConfigurationTemplateFactoryInputForHost;
import test.unit.net.alepuzio.cobol2java.generaFile.output.TestConfigurationTemplateFactoryInputFromHost;
import test.unit.net.alepuzio.cobol2java.generaFile.process.TestGenerateBean;
import test.unit.net.alepuzio.cobol2java.generaFile.process.TestGenerateXML;

@RunWith(Suite.class)
@SuiteClasses({ TestAttr.class, TestAttributeSet.class,

	TestConfigurationTemplateFactoryInputForHost.class, TestConfigurationTemplateFactoryInputFromHost.class,
	TestGenerateBean.class/*, TestGenerateSuperClass.class*/, TestGenerateXML.class

})
public class AllTests {

}
