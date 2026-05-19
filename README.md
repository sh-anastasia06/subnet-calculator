# Subnet Calculator

A command-line subnet calculator built in Java. Enter an IP address in CIDR notation and get full subnet information instantly.

## Output Example

```
===== SUBNET CALCULATOR =====
Enter IP/CIDR (or 'exit' to quit): 192.168.1.10/24

=== SUBNET INFO ===
IP Address      : 192.168.1.10
Subnet Mask     : 255.255.255.0
Network Address : 192.168.1.0
Broadcast       : 192.168.1.255
First Host      : 192.168.1.1
Last Host       : 192.168.1.254
Usable Hosts    : 254
CIDR Notation   : /24
```

## Project Structure

```
subnet-calculator/
├── src/
│   └── com/
│       └── network/
│           ├── Main.java
│           ├── IPAddress.java
│           ├── SubnetCalculator.java
│           └── SubnetInfo.java
└── README.md
```

## Classes

| Class | Responsibility |
|---|---|
| `Main.java` | Entry point — handles user input loop and validation |
| `IPAddress.java` | Converts IP strings to 32-bit integers and back |
| `SubnetCalculator.java` | Core bitwise logic — computes mask, network, broadcast, hosts |
| `SubnetInfo.java` | Data model holding all subnet results, formats output |

## How to Run

### Compile
```bash
javac src/com/network/*.java -d out/
```

### Run
```bash
java -cp out com.network.Main
```

## How It Works

All subnet calculations are done using **bitwise operations** on 32-bit integers.

| Value | Operation |
|---|---|
| Subnet Mask | `-1 << (32 - prefix)` |
| Network Address | `ip & mask` |
| Broadcast | `network \| ~mask` |
| First Host | `network + 1` |
| Last Host | `broadcast - 1` |
| Usable Hosts | `lastHost - firstHost + 1` |

## Concepts Practiced

- CCNA-1: IP addressing, subnetting, CIDR notation
- Java: bitwise operations, regex validation, OOP class design
