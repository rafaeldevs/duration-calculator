# duration-calculator

Sums up the durations of records, such as songs or recipes, measured in minutes - seconds (i.e. mm:ss)


## Example Usage

To run the examples you must be able to run babashka tasks from the command line.

> *Babashka* is a native Clojure interpreter for scripting with fast startup.

> Clojure is a concise, powerful, and performant general-purpose  programming language that runs on the Java Virtual Machine, Common Language Runtime, JavaScript runtimes (aka Node.js or modern mobile/desktop web browsers), and Babashka.

See the [Babashka documentation](https://github.com/babashka/babashka#installation) for more information


### Setup

This project ships with batteries included. In other words after installing Babashka and granting the correct permissions to the add-track-times.clj file you should be able to issue commands successfully.

If you have a list of records with durations in `mm:ss` format and wish to sum them up take a look at the sample `records.edn` file provided. This file is where this duration calulator program gets all the data it requires to function.

### Description of `records.edn` data file

Each record must have at least to elements

1. **label**: The name or identifier of the record as a string
2. **duration**: The duration of the record in minute-seconds (i.e mm:ss)
3. **url**: An optional URL, description, etc

```
[["Paper" "03:55" "https://open.spotify.com/track/3ONGM7lWDHx2zG2J5GoCn2?si=5e71820591fc4339"]
 ["Santa" "04:10"]
 ["WhatAmIOn" "02:43" "https://open.spotify.com/track/66CoyCEpCLIxg1ftUfgJoh?si=255ebb839f8143a1"]
 ["Agua Salada" "03:47" "https://open.spotify.com/track/0D2cnBK2IuinKECn7IR8Ek?si=c908590d0b884dc1"]
 ["Candela" "04:03"]]
```

### Available Babashka tasks

The following functionality is available as Babaska tasks

#### average

  Average duration

  Usage: `bb run average`

  ![`bb run average`](bb-run-average.png) 

#### durations-seconds
  
  List of durations in seconds

  Usage: `bb run durations-seconds`

  ![`bb run durations-seconds`](bb-run-durations-seconds.png) 

#### help

  Help message

  Usage: `bb run help`

  ![`bb run help`](bb-run-help.png)

#### list

  Lists all labeled records and their duration (mm:ss)

  Usage: `bb run list`

  ![`bb run list`](bb-run-list.png) 

#### list-durations

  Lists records duration (mm:ss)

  Usage: `bb run list-durations`

  ![`bb run list-durations`](bb-run-list-durations.png) 

#### list-labels

  Lists records Lables

  Usage: `bb run list-labels`

  ![`bb run list-labels`](bb-run-list-labels.png) 

#### list-urls

  Lists records with urls

  Usage: `bb run list-urls`

  ![`bb run list-urls`](bb-run-list-urls.png) 

#### total

  Total duration (mm:ss)

  Usage: `bb run total`

  ![`bb run total`](bb-run-total.png) 

#### total-seconds

  Total duration (s)

  Usage: `bb run total-seconds`
  
  ![`bb run total-seconds`](bb-run-total-seconds.png)



