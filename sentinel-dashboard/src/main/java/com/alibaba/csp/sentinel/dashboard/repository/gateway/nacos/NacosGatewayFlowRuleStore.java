/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.csp.sentinel.dashboard.repository.gateway.nacos;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.GatewayFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.repository.rule.nacos.NacosRuleRepositoryAdapter;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Store {@link GatewayFlowRuleEntity} in memory.
 *
 * @author cdfive
 * @since 1.7.0
 */
@Component
@Primary
public class NacosGatewayFlowRuleStore extends NacosRuleRepositoryAdapter<GatewayFlowRuleEntity> {

    private static AtomicLong ids = new AtomicLong(0);

    public NacosGatewayFlowRuleStore(DynamicRuleProvider<List<GatewayFlowRuleEntity>> ruleProvider, DynamicRulePublisher<List<GatewayFlowRuleEntity>> rulePublisher) {
        super(ruleProvider, rulePublisher);
    }

    @Override
    protected long nextId() {
        return ids.incrementAndGet();
    }
}
