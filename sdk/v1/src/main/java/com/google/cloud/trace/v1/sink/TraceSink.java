// Copyright 2016 Google Inc. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.cloud.trace.v1.sink;

import com.google.devtools.cloudtrace.v1.Trace;

/**
 * An interface for a trace sink that accepts Stackdriver Trace API v1 trace messages.
 *
 * @see Trace
 */
public interface TraceSink {
  /**
   * Accepts a Stackdriver Trace API v1 trace message.
   *
   * @param trace a trace that is accepted by this sink.
   */
  void receive(Trace trace);
}
