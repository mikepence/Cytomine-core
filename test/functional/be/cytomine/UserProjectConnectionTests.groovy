package be.cytomine

/*
* Copyright (c) 2009-2015. Authors: see NOTICE file.
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

import be.cytomine.test.BasicInstanceBuilder
import be.cytomine.test.Infos
import be.cytomine.test.http.UserProjectConnectionAPI
import grails.converters.JSON

class UserProjectConnectionTests {


    void testAddPosition() {
        def project = BasicInstanceBuilder.getProject()
        def json = JSON.parse("{project:${project.id}}");

        def result = UserProjectConnectionAPI.create(project.id, json.toString(),Infos.SUPERADMINLOGIN, Infos.SUPERADMINPASSWORD)
        assert 200 == result.code

        result = UserProjectConnectionAPI.getConnectionByUserAndProject(BasicInstanceBuilder.user1.id, project.id,Infos.SUPERADMINLOGIN, Infos.SUPERADMINPASSWORD)
        assert 200 == result.code
        result = UserProjectConnectionAPI.lastConnectionInProject(project.id,Infos.SUPERADMINLOGIN, Infos.SUPERADMINPASSWORD)
        assert 200 == result.code
        result = UserProjectConnectionAPI.numberOfConnectionsByProject(project.id,Infos.SUPERADMINLOGIN, Infos.SUPERADMINPASSWORD)
        assert 200 == result.code
        result = UserProjectConnectionAPI.numberOfConnectionsByUserAndProject(BasicInstanceBuilder.user1.id, project.id,Infos.SUPERADMINLOGIN, Infos.SUPERADMINPASSWORD)
        assert 200 == result.code
    }



    void testGetConnectionByUserAndProject() {
        def project = BasicInstanceBuilder.getProject()
        def json = JSON.parse("{project:${project.id}}");

        def result = UserProjectConnectionAPI.create(project.id, json.toString(),Infos.SUPERADMINLOGIN, Infos.SUPERADMINPASSWORD)
        assert 200 == result.code

        result = UserProjectConnectionAPI.getConnectionByUserAndProject(BasicInstanceBuilder.user1.id,project.id,Infos.SUPERADMINLOGIN, Infos.SUPERADMINPASSWORD)
        assert 200 == result.code
    }

    void testLastConnectionInProject() {
        def project = BasicInstanceBuilder.getProject()
        def json = JSON.parse("{project:${project.id}}");

        def result = UserProjectConnectionAPI.create(project.id, json.toString(),Infos.SUPERADMINLOGIN, Infos.SUPERADMINPASSWORD)
        assert 200 == result.code

        result = UserProjectConnectionAPI.lastConnectionInProject(project.id,Infos.SUPERADMINLOGIN, Infos.SUPERADMINPASSWORD)
        assert 200 == result.code
    }

    void testNumberOfConnectionsByProject() {
        def project = BasicInstanceBuilder.getProject()
        def json = JSON.parse("{project:${project.id}}");

        def result = UserProjectConnectionAPI.create(project.id, json.toString(),Infos.SUPERADMINLOGIN, Infos.SUPERADMINPASSWORD)
        assert 200 == result.code

        result = UserProjectConnectionAPI.numberOfConnectionsByProject(project.id,Infos.SUPERADMINLOGIN, Infos.SUPERADMINPASSWORD)

        assert 200 == result.code
    }



    void testNumberOfConnectionsByUserAndProject() {
        def project = BasicInstanceBuilder.getProject()

        def json = JSON.parse("{project:${project.id}}");

        def result = UserProjectConnectionAPI.create(project.id, json.toString(),Infos.SUPERADMINLOGIN, Infos.SUPERADMINPASSWORD)
        assert 200 == result.code

        result = UserProjectConnectionAPI.numberOfConnectionsByUserAndProject(BasicInstanceBuilder.user1.id, project.id, Infos.SUPERADMINLOGIN, Infos.SUPERADMINPASSWORD)
        assert 200 == result.code
    }


}