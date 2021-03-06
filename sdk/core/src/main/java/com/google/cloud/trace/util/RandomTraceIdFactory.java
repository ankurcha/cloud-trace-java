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

package com.google.cloud.trace.util;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * An factory for generating trace identifiers. This factory uses a {@link SecureRandom} to produce
 * trace identifiers.
 *
 * @see AbstractTraceIdFactory
 * @see IdFactory
 * @see SecureRandom
 * @see TraceId
 */
public class RandomTraceIdFactory extends AbstractTraceIdFactory {
  private static final int TRACE_ID_BIT_LENGTH = 128;

  private final SecureRandom random;

  /**
   * Creates a new trace identifier factory. This constructor generates a {@code SecureRandom} using
   * a default seed.
   */
  public RandomTraceIdFactory() {
    this.random = new SecureRandom();
  }

  /**
   * Creates a new trace identifier factory. This constructor generates a {@code SecureRandom} using
   * the given seed.
   *
   * @param seed a byte array used as the seed.
   */
  public RandomTraceIdFactory(byte[] seed) {
    this.random = new SecureRandom(seed);
  }

  /**
   * Creates a new trace identifier factory.
   *
   * @param random a secure random used to generate trace identifiers.
   */
  public RandomTraceIdFactory(SecureRandom random) {
    this.random = random;
  }

  /**
   * Generates a new trace identifier.
   *
   * @return the new trace identifier.
   */
  @Override
  public TraceId nextId() {
    return new TraceId(new BigInteger(TRACE_ID_BIT_LENGTH, random));
  }
}
