package com.jie.druid;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jie.druid.entity.RuleModelResultMingjue;
import com.jie.druid.service.impl.RuleModelResultMingjueServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DruidApplicationTests {
    private Logger logger= LogManager.getLogger(DruidApplicationTests.class);


    @Autowired
    private RuleModelResultMingjueServiceImpl ruleModelResultMingjueService;

    /**
     * 流程定义的部署
     */

    /*public void createDeploy() {
        RepositoryService repositoryService = processEngine.getRepositoryService();

        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("diagram/test.bpmn")//添加bpmn资源
                //.addClasspathResource("diagram/test.png")
                .name("审批流程")
                .deploy();

        logger.info("流程部署id:" + deployment.getName());
        logger.info("流程部署名称:" + deployment.getId());
    }*/
    @Test
    public void Mingjue(){
        QueryWrapper<RuleModelResultMingjue> queryWrapper=new QueryWrapper<>();

        List<RuleModelResultMingjue> ruleModelResultMingjues = ruleModelResultMingjueService.list(queryWrapper);
        ruleModelResultMingjues.forEach(ruleModelResultMingjue -> System.out.println(
                ruleModelResultMingjue.toString()
        ));
    }

}
