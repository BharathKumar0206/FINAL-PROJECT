---
title: Event Queue
category: Concurrency
language: en
tag:
    - Asynchronous
    - Decoupling
    - Messaging
    - Event-driven
    - Scalability
---

## Also known as

* Event Stream
* Message Queue

## Intent

The Event Queue pattern is designed to manage tasks in an asynchronous manner, allowing applications to handle operations without blocking user interactions or other processes.

![Event Queue](./etc/event-queue-model.png "Event Queue Visualised")

## Explanation

Real world example

> The modern emailing system is an example of the fundamental process behind the event-queue design pattern. When an email is sent, the sender continues their daily tasks without the necessity of an immediate response from the receiver. Additionally, the receiver has the freedom to access and process the email at their leisure. Therefore, this process decouples the sender and receiver so that they are not required to engage with the queue at the same time.


In plain words

> The buffer between sender and receiver improves maintainability and scalability of a system. Event queues are typically used to organise and carry out interprocess communication (IPC).

Wikipedia says

> Message queues (also known as event queues) implement an asynchronous communication pattern between two or more processes/threads whereby the sending and receiving party do not need to interact with the queue at the same time.


Key drawback

> As the event queue model decouples the sender-receiver relationship - this means that the event-queue design pattern is unsuitable for scenarios in which the sender requires a response. For example, this is a prominent feature within online multiplayer games, therefore, this approach require thorough consideration.

**Programmatic Example**

This example demonstrates an application using an event queue system to handle audio playback asynchronously.

The App class sets up an instance of Audio, plays two sounds, and waits for user input to exit. It demonstrates how an event queue could be used to manage asynchronous operations in a software application.

```java
public class App {

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException,
            InterruptedException {
        var audio = Audio.getInstance();
        audio.playSound(audio.getAudioStream("./etc/Bass-Drum-1.wav"), -10.0f);
        audio.playSound(audio.getAudioStream("./etc/Closed-Hi-Hat-1.wav"), -8.0f);

        LOGGER.info("Press Enter key to stop the program...");
        try (var br = new BufferedReader(new InputStreamReader(System.in))) {
            br.read();
        }
        audio.stopService();
    }
}
```

The Audio class holds the singleton pattern implementation, manages a queue of audio play requests, and controls thread operations for asynchronous processing.

```java
public class Audio {
    private static final Audio INSTANCE = new Audio();

    private static final int MAX_PENDING = 16;

    private int headIndex;

    private int tailIndex;

    private volatile Thread updateThread = null;

    private final PlayMessage[] pendingAudio = new PlayMessage[MAX_PENDING];

    Audio() {}

    public static Audio getInstance() {
        return INSTANCE;
    }
}
```

These methods manage the lifecycle of the thread used to process the audio events. The init and startThread methods ensure the thread is properly initialized and running.

```java
public synchronized void stopService() throws InterruptedException {
    if(updateThread != null) {
        updateThread.interrupt();
        updateThread.join();
        updateThread = null;
    }
}

public synchronized boolean isServiceRunning() {
    return updateThread != null && updateThread.isAlive();
}

public void init() {
    if(updateThread == null) {
        updateThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                update();
            }
        });
        startThread();
    }
}

private synchronized void startThread() {
    if (!updateThread.isAlive()) {
        updateThread.start();
        headIndex = 0;
        tailIndex = 0;
    }
}
```

The playSound method checks if the audio is already in the queue and either updates the volume or enqueues a new request, demonstrating the management of asynchronous tasks within the event queue.

```java
public void playSound(AudioInputStream stream, float volume) {
    init();
    for(var i = headIndex; i != tailIndex; i = (i + 1) % MAX_PENDING) {
        var playMessage = getPendingAudio()[i];
        if(playMessage.getStream() == stream) {
            playMessage.setVolume(Math.max(volume, playMessage.getVolume()));
            return;
        }
    }
    getPendingAudio()[tailIndex] = new PlayMessage(stream, volume);
    tailIndex = (tailIndex + 1) % MAX_PENDING;
}
```

## Class diagram

![alt text](./etc/model.png "Event Queue")

## Applicability

This pattern is applicable in scenarios where tasks can be handled asynchronously outside the main application flow, such as in GUI applications, server-side event handling, or in systems that require task scheduling without immediate execution. In particular:

* The sender does not require a response from the receiver.
* You wish to decouple the sender & the receiver.
* You want to process events asynchronously.
* You have a limited accessibility resource and the asynchronous process is acceptable to reach that.

## Known Uses

* Event-driven architectures
* GUI frameworks in Java (such as Swing and JavaFX)
* Server applications handling requests asynchronously

## Consequences

Benefits:

* Reduces system coupling.
* Enhances responsiveness of applications.
* Improves scalability by allowing event handling to be distributed across multiple threads or processors.

Trade-offs:

* Complexity in managing the event queue.
* Potential for difficult-to-track bugs due to asynchronous behavior.
* Overhead of maintaining event queue integrity and performance.

## Related Patterns

* [Command](https://java-design-patterns.com/patterns/command/) (for encapsulating request processing in a command object)
* [Observer](https://java-design-patterns.com/patterns/observer/) (for subscribing and notifying changes to multiple observers)
* [Reactor](https://java-design-patterns.com/patterns/reactor/) (handles requests in a non-blocking event-driven manner similar to Event Queue)

## Credits

* [Pattern-Oriented Software Architecture, Volume 2: Patterns for Concurrent and Networked Objects](https://amzn.to/3U2hlcy)
* [Java Concurrency in Practice](https://amzn.to/3Ji16mX)
* [Patterns of Enterprise Application Architecture](https://amzn.to/3xtVtPJ)
* [Enterprise Integration Patterns: Designing, Building, and Deploying Messaging Solutions](https://amzn.to/3xzSlC2)
* [Mihaly Kuprivecz - Event Queue] (http://gameprogrammingpatterns.com/event-queue.html)
* [Wikipedia - Message Queue] (https://en.wikipedia.org/wiki/Message_queue)
* [AWS - Message Queues] (https://aws.amazon.com/message-queue/)
