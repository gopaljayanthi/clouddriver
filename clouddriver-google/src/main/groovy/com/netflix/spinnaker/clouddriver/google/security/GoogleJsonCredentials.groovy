/*
 * Copyright 2016 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.clouddriver.google.security

import com.google.api.services.compute.ComputeScopes
import com.netflix.spinnaker.clouddriver.google.ComputeVersion
import com.netflix.spinnaker.clouddriver.googlecommon.security.GoogleCommonCredentialUtils
import groovy.transform.CompileStatic

@CompileStatic
class GoogleJsonCredentials extends GoogleCredentials {
  final String jsonKey

  GoogleJsonCredentials(String project, ComputeVersion computeVersion, String jsonKey) {
    super(project, computeVersion)
    this.jsonKey = jsonKey
  }

  @Override
  com.google.auth.oauth2.GoogleCredentials getCredentials() {
    GoogleCommonCredentialUtils.getCredentials(jsonKey, ComputeScopes.COMPUTE);
  }
}
