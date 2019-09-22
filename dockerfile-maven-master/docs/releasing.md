# Releasing

```
mvn -P release -Dgpg.keyname=<key-ID> release:clean release:prepare release:perform --batch-mode
```
