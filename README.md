# Multi-threaded Timer

A Java console application with multiple timers

### __Features__

Users can

- Start timers and give them a Name.
- Stop a timer by Name.
- Check a timer by Name or all timers (without a Name ).
- Starting a timer creates a new thread which increments a counter to keep track of elapsed seconds. Starting an already stopped timer restarts it.

Stopping a timer interrupts the thread created when the timer was started effectively stopping the timer (the counter won't be incremented anymore). Timer threads should check/handle and react accordingly for interrupts while they execute.

Checking a timer prints information about the timer itself: it's name, it's thread ID and the elapsed seconds. Users can check timers that are already stopped.

### __Requirements__

- Use Threads or Runnables.
- Use interrupt.
- Commit your work into a Git repository and submit your repo's URL.

### __Example Scenario__

```shell script
Command?
start TEA

Command?
check
Name: TEA, ThreadId: 11, Seconds: 1

... after 7 seconds ...

Command?
start COFFEE

Command?
check
Name: TEA, ThreadId: 11, Seconds: 8
Name: COFFEE, ThreadId: 12, Seconds: 1

... after 5 seconds ...

Command?
stop TEA
TEA received interrupt while sleeping

... after 16 seconds ...

Command?
check
Name: TEA, ThreadId: 11, Seconds: 13
Name: COFFEE, ThreadId: 12, Seconds: 22

... after 8 seconds ...

Command?
start TEA

Command?
check
Name: TEA, ThreadId: 13, Seconds: 15
Name: COFFEE, ThreadId: 12, Seconds: 30

... after 4 seconds ...

Command?
exit
Name: TEA, ThreadId: 13, Seconds: 19
Name: COFFEE, ThreadId: 12, Seconds: 34
```
