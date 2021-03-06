/*
 * Copyright 2007 The Fornax Project Team, including the original
 * author or authors.
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
package org.fornax.cartridges.sculptor.framework.web.jpa;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.fornax.cartridges.sculptor.framework.web.hibernate.ConversationDomainObjectRepository;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.support.JpaDaoSupport;

public class ConversationDomainObjectJpaRepositoryImpl extends JpaDaoSupport implements
        ConversationDomainObjectRepository {

    public <T> T get(Class<T> domainObjectClass, Serializable id) {
        return getJpaTemplate().find(domainObjectClass, id);
    }

    public void revert(Object domainObject) {
        if (getJpaTemplate().contains(domainObject)) {
            getJpaTemplate().refresh(domainObject);

        }
    }

    public void clear() {
        getJpaTemplate().execute(new JpaCallback() {
            public Object doInJpa(EntityManager em) throws PersistenceException {
                em.clear();
                return null;
            }

        });
    }
}
