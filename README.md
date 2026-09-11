# luvx-char_sequence

**A tiny foundation module: lets a Java `enum` constant behave as a `CharSequence`, so enum-based typed constants (CSS classes, tag names, attribute names, ...) can be used anywhere a string-like value is expected.**

```xml
<dependency>
    <groupId>io.github.luvml</groupId>
    <artifactId>luvx-char_sequence</artifactId>
    <version>2.0</version>
</dependency>
```

**Requires:** JDK 21+ · no other dependencies

## What it provides

- **`DelegatedCharSeq`** — implement one method (`delegatedCharSeqVal()`) and get the full `CharSequence` contract for free.
- **`NamedEnum`** — the `name()` every Java enum constant already has, exposed as an interface so it can be depended on generically.
- **`NamedEnumCharSeq`** — combines the two: any enum that implements it is usable as a `CharSequence` using its own constant name, with zero boilerplate.

```java
enum CssClass implements NamedEnumCharSeq { container, card, btn }

// CssClass.card now works anywhere a CharSequence/String is expected,
// rendering as "card" — while still being a real, type-safe enum constant
// (IDE rename, find-all-references, and exhaustive switch all still work).
```

This is the mechanism that lets [luvml](https://github.com/luvml/luvml) and [luvs](https://github.com/luvml/luvs) treat enum constants as HTML class names, tag names and similar without ever converting them to plain strings.

## Related Projects

- **[luvx-base](https://github.com/luvml/luvx-base)** — the sibling foundation module (the generic `Frag_I`/DSL machinery)
- **[luvml](https://github.com/luvml/luvml)** — type-safe HTML/XHTML generation
- **[luvs](https://github.com/luvml/luvs)** — type-safe CSS generation

## License

Apache License 2.0 — see [LICENSE](LICENSE).
