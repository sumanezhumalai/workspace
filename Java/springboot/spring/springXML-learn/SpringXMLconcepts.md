# Spring XML Concepts

1. **IoC Container** — Spring owns object creation and wiring; app asks the container instead of using `new`.
2. **ApplicationContext (ClassPathXmlApplicationContext)** — IoC container implementation that loads bean definitions from an XML file on the classpath.
3. **Bean** — An object instantiated and managed by the container, declared via `id` (lookup name) + `class` (type to instantiate).
4. **Bean Scope: singleton** — Default. One shared instance per container, created eagerly at startup.
5. **Bean Scope: prototype** — New instance per request, created lazily on each lookup.
6. **Setter Injection (`value`)** — Container sets primitive/String fields by calling setters after construction; decouples values from Java code.
7. **Setter Injection (`ref`)** — Container wires one bean into another by passing a bean reference to a setter; `value` = literal, `ref` = bean id.
8. **Constructor Injection (`<constructor-arg>`)** — Container passes values/beans as constructor arguments at creation; object is fully initialized with no setters needed. Match args by `index` (safest) or `type`; `name` needs the `-parameters` compiler flag.
9. **Autowiring (`autowire="byType/byName"`)** — Container auto-detects which bean to inject into a setter/constructor without an explicit `ref`; only works for bean references, not primitives. `byType` needs exactly one matching bean; `byName` matches bean id to property name.
10. **Primary Bean (`primary="true"`)** — Tiebreaker when multiple beans share a type; `byType` autowiring picks the primary one instead of failing as ambiguous.
11. **Lazy Init (`lazy-init="true"`)** — Bean is created on first use, not at container startup; default singletons are eager.
12. **getBean(Class<Type>) — type-based lookup:** returns the unique bean of that type (must be primary if multiple exist); same as `getBean("id")` but uses type instead of name.
13. **Inner Bean** — Bean defined inside a `<property>`/`<constructor-arg>` with no id; visible only to the enclosing bean, never shareable or directly look-up-able.
