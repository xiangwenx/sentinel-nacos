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
package com.alibaba.csp.sentinel.dashboard.repository.rule.nacos;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.AuthorityRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * In-memory storage for authority rules.
 *
 * @author Eric Zhao
 * @since 0.2.1
 */
@Component
@Primary
public class NacosAuthorityRuleStore extends NacosRuleRepositoryAdapter<AuthorityRuleEntity> {

    private static AtomicLong ids = new AtomicLong(0);

    public NacosAuthorityRuleStore(DynamicRuleProvider<List<AuthorityRuleEntity>> ruleProvider, DynamicRulePublisher<List<AuthorityRuleEntity>> rulePublisher) {
        super(ruleProvider, rulePublisher);
    }

    @Override
    protected long nextId() {
        return ids.incrementAndGet();
    }
}
