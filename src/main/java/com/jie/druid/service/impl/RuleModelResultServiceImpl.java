package com.jie.druid.service.impl;

import com.jie.druid.annotation.TargetDataSource;
import com.jie.druid.entity.RuleModelResult;
import com.jie.druid.enums.DataSourceEnum;
import com.jie.druid.mapper.RuleModelResultDao;
import com.jie.druid.service.IRuleModelResultService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wsj
 * @since 2019-11-07
 */
@Service

public class RuleModelResultServiceImpl extends ServiceImpl<RuleModelResultDao, RuleModelResult> implements IRuleModelResultService {

}
