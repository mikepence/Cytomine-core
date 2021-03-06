/*
* Copyright (c) 2009-2017. Authors: see NOTICE file.
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



import be.cytomine.ldap.LdapUlgMemberPersonContextMapper
import be.cytomine.security.CASLdapUserDetailsService
import be.cytomine.web.CytomineMultipartHttpServletRequest
import grails.plugin.springsecurity.SpringSecurityUtils
import org.springframework.cache.ehcache.EhCacheFactoryBean

//import grails.plugin.springsecurity.SpringSecurityUtils
// Place your Spring DSL code here
beans = {
    'apiAuthentificationFilter'(cytomine.web.APIAuthentificationFilters) {
        // properties
    }
    'multipartResolver'(CytomineMultipartHttpServletRequest) {
        // Max in memory 100kbytes
        maxInMemorySize=10240

        //100Gb Max upload size
        maxUploadSize=102400000000


    }
    userDetailsService(be.cytomine.security.CASLdapUserDetailsService)
    springConfig.addAlias "springSecurityService", "springSecurityCoreSpringSecurityService"
    
    //CAS + LDAP STUFF
    def config = SpringSecurityUtils.securityConfig
    SpringSecurityUtils.loadSecondaryConfig 'DefaultLdapSecurityConfig'
    config = SpringSecurityUtils.securityConfig
    

    initialDirContextFactory(org.springframework.security.ldap.DefaultSpringSecurityContextSource,
            config.ldap.context.server){
        userDn = config.ldap.context.managerDn
        password = config.ldap.context.managerPassword
        anonymousReadOnly = config.ldap.context.anonymousReadOnly
    }

    ldapUserSearch(org.springframework.security.ldap.search.FilterBasedLdapUserSearch,
            config.ldap.search.base,
            config.ldap.search.filter,
            initialDirContextFactory){
    }

    ldapAuthoritiesPopulator(org.springframework.security.ldap.userdetails.DefaultLdapAuthoritiesPopulator,
            initialDirContextFactory,
            config.ldap.authorities.groupSearchBase){
        groupRoleAttribute = config.ldap.authorities.groupRoleAttribute
        groupSearchFilter = config.ldap.authorities.groupSearchFilter
        searchSubtree = config.ldap.authorities.searchSubtree
        convertToUpperCase = config.ldap.mapper.convertToUpperCase
        ignorePartialResultException = config.ldap.authorities.ignorePartialResultException
    }

    ldapUserDetailsMapper(LdapUlgMemberPersonContextMapper)

    ldapUserDetailsService(org.springframework.security.ldap.userdetails.LdapUserDetailsService,
            ldapUserSearch,
            ldapAuthoritiesPopulator){
        userDetailsMapper = ref('ldapUserDetailsMapper')
    }

    userDetailsService(CASLdapUserDetailsService) {
        ldapUserDetailsService=ref('ldapUserDetailsService')
        grailsApplication = ref('grailsApplication')
    }

    ehcacheAclCache(EhCacheFactoryBean) {
        cacheManager = ref('aclCacheManager')
        cacheName = 'aclCache'
        overflowToDisk = false
    }

    currentRoleServiceProxy(org.springframework.aop.scope.ScopedProxyFactoryBean) {
        targetBeanName = 'currentRoleService'
        proxyTargetClass = true
    }
}
