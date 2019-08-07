## QuickTheory Unlimited Examples + Time Issue Reproducer

This is a minimal sample project which tests using quicktheory and unlimited examples with adding a time constraint.
The time constraint should kick off and end the tests, but it seems like unlimited examples wins and the long generator `Gen<Long>` keeps going forever,
which infinitely generates longs and invokes:

```
TheoryBuilder.check(final Predicate<A> property)
```

This seems like a bug to me. The java docs say that the time constraint should be obeyed.