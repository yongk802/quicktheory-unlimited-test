package com.attivio.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.Generate.longRange;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;
import org.quicktheories.core.Gen;

public class TestTimedUnlimitedExamples {

  @Test
  void testUnlimitedExamplesAndTime() {
    Gen<Long> maxBatchTimeGenerator = longRange(10, 2000);
    testTheory(
        maxBatchTimeGenerator,
        maxBatchTime -> {
          LongHolder longHolder = new LongHolder(maxBatchTime);
          assertEquals(maxBatchTime, longHolder.getDuration());
        });
  }

  static <T> void testTheory(Gen<T> generator, Consumer<T> assertion) {
        qt().withUnlimitedExamples()
        .withTestingTime(1, TimeUnit.SECONDS)
        .forAll(generator)
        .checkAssert(assertion);
  }

}
