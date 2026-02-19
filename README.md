# PrimeChecker

Simple java app that reads numbers from an excel file and prints out which ones are prime.

## Requirements

- Java 21
- Maven 3.x

## Build

```bash
mvn clean package
```

This creates a fat jar (with all deps bundled) in `target/prime-checker-1.0-SNAPSHOT.jar`.

## Run

```bash
java -jar target/prime-checker-1.0-SNAPSHOT.jar path/to/your/file.xlsx
```

Example:

```bash
java -jar target/prime-checker-1.0-SNAPSHOT.jar "vzorek_dat - kopie.xlsx"
```

The app will print all prime numbers it finds, one per line.

## Tests

```bash
mvn test
```

## Notes

- The Excel file needs to have numbers in column B, first row is treated as header so its skipped
- Non-numeric cells are silently ignored
- App exits with code 1 if the file doesnt exist or something goes wrong