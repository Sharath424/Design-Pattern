# Design-Pattern

![Java](images/Java.png)


## What is a Pattern

* Design patterns are typical solutions to commonly occurring problems in software design. 

* They are like pre-made blueprints that you can customize to solve a recurring design problem in your code.

* You can’t just find a pattern and copy it into your program, the way you can with off-the-shelf functions or libraries. 

* The pattern is not a specific piece of code, but a general concept for solving a particular problem. 

* You can follow the pattern details and implement a solution that suits the realities of your own program.

* Patterns are often confused with algorithms, because both concepts describe typical solutions to some known problems. 

* While an algorithm always defines a clear set of actions that can achieve some goal, a pattern is a more high-level description of a solution. 

* The code of the same pattern applied to two different programs may be different.

### What does the pattern consist of?

Here are the sections that are usually present in a pattern description:

* **Intent** of the pattern briefly describes both the problem and the solution.

* **Motivation** further explains the problem and the solution the pattern makes possible.

* **Structure** of classes shows each part of the pattern and how they are related.

* **Code example** in one of the popular programming languages makes it easier to grasp the idea behind the pattern.

### Why should I learn patterns?

* The truth is that you might manage to work as a programmer for many years without knowing about a single pattern.

* Design patterns are a toolkit of tried and tested solutions to common problems in software design. 

* Even if you never encounter these problems, knowing patterns is still useful because it teaches you how to solve all sorts of problems using principles of object-oriented design.

* Design patterns define a common language that you and your teammates can use to communicate more efficiently.

* You can say, “Oh, just use a Singleton for that,” and everyone will understand the idea behind your suggestion. No need to explain what a singleton is if you know the pattern and its name

### Classification of patterns

* Design patterns differ by their complexity, level of detail and scale of applicability to the entire system being designed.

* The most basic and low-level patterns are often called idioms. They usually apply only to a single programming language.

* The most universal and high-level patterns are architectural patterns. Developers can implement these patterns in virtually any language. Unlike other patterns, they can be used to design the architecture of an entire application.

* In addition, all patterns can be categorized by their intent, or purpose. This covers three main groups of patterns:

1. **[Creational patterns](#creational-patterns)** provide object creation mechanisms that increase flexibility and reuse of existing code.

2. **[Structural patterns](#structural-patterns)** explain how to assemble objects and classes into larger structures , while keeping these structures flexible and efficient.

3. **[Behavioral patterns](#behavioral-patterns)** take care of effective communication and the assignment of responsibilities between objects.

## Catalogs

1. Creational Design Pattern

* [Factory Pattern](#factory-method)

* [Abstract Factory Pattern](#abstract-factory)

* [Singleton Pattern](#singleton)

* [Prototype Pattern](#prototype)

* [Builder Pattern](#builder)

2. Structural Design Pattern

* [Adapter Pattern](#adapter)

* [Bridge Pattern](#bridge)

* [Composite Pattern](#composite)

* [Facade Pattern](#facade)

* [Flyweight Pattern](#flyweight)

* [Proxy Pattern](#proxy)


3. Behavioral Design Pattern

* [Chain Of Responsibility Pattern](#chain-of-responsibility)

* [Command Pattern](#command)

* [Iterator Pattern](#iterator)

* [Mediator Pattern](#mediator)

* [Memento Pattern](#memento)

* [Observer Pattern](#observer)

* [State Pattern](#state)

* [Strategy Pattern](#strategy)

* [Template Pattern](#template-method)

### Creational Patterns

Creational design patterns are concerned with the way of creating objects.

These design patterns are used when a decision must be made at the time of instantiation of a class (i.e. creating an object of a class)

Types of creational design patterns

* [Factory Pattern](#factory-method)

* [Abstract Factory Pattern](#abstract-factory)

* [Singleton Pattern](#singleton)

* [Prototype Pattern](#prototype)

* [Builder Pattern](#builder)


#### Factory Method

![Factory](images/Factory.png)

Factory method is a creational design pattern which solves the problem of creating product objects without specifying their concrete classes.

The Factory Method defines a method, which should be used for creating objects instead of using a direct constructor call (new operator). Subclasses can override this method to change the class of objects that will be created.

##### Pseudocode

The base Dialog class uses different UI elements to render its window. Under various operating systems, these elements may look a little bit different, but they should still behave consistently. A button in Windows is still a button in Linux.

When the factory method comes into play, you don’t need to rewrite the logic of the Dialog class for each operating system. If we declare a factory method that produces buttons inside the base Dialog class, we can later create a subclass that returns Windows-styled buttons from the factory method. The subclass then inherits most of the code from the base class, but, thanks to the factory method, can render Windows-looking buttons on the screen.

For this pattern to work, the base Dialog class must work with abstract buttons: a base class or an interface that all concrete buttons follow. This way the code within Dialog remains functional, whichever type of buttons it works with.

Of course, you can apply this approach to other UI elements as well. However, with each new factory method you add to the Dialog, you get closer to the Abstract Factory pattern. Fear not, we’ll talk about this pattern later.

##### Code Example

![Factory](images/Faxtory-example.png)

* Code

(https://github.com/Sharath424/Design-Pattern/tree/main/Factory%20Method/Factory/src)

* Output text

```
<button>Test Button</button>
Click! Button says - 'Hello World!
```

* Output png

![Factory](images/Factory-output.png)


#### Abstract Factory

![Abstract](images/Abstract-factory.png)

Abstract Factory is a creational design pattern, which solves the problem of creating entire product families without specifying their concrete classes.


Abstract Factory defines an interface for creating all distinct products but leaves the actual product creation to concrete factory classes. Each factory type corresponds to a certain product variety.

The client code calls the creation methods of a factory object instead of creating products directly with a constructor call (new operator). Since a factory corresponds to a single product variant, all its products will be compatible.

Client code works with factories and products only through their abstract interfaces. This lets the client code work with any product variants, created by the factory object. You just create a new concrete factory class and pass it to the client code.

#####  Pseudocode

This example illustrates how the Abstract Factory pattern can be used for creating cross-platform UI elements without coupling the client code to concrete UI classes, while keeping all created elements consistent with a selected operating system.

The same UI elements in a cross-platform application are expected to behave similarly, but look a little bit different under different operating systems. Moreover, it’s your job to make sure that the UI elements match the style of the current operating system. You wouldn’t want your program to render macOS controls when it’s executed in Windows.

The Abstract Factory interface declares a set of creation methods that the client code can use to produce different types of UI elements. Concrete factories correspond to specific operating systems and create the UI elements that match that particular OS.

It works like this: when an application launches, it checks the type of the current operating system. The app uses this information to create a factory object from a class that matches the operating system. The rest of the code uses this factory to create UI elements. This prevents the wrong elements from being created.

With this approach, the client code doesn’t depend on concrete classes of factories and UI elements as long as it works with these objects via their abstract interfaces. This also lets the client code support other factories or UI elements that you might add in the future.

As a result, you don’t need to modify the client code each time you add a new variation of UI elements to your app. You just have to create a new factory class that produces these elements and slightly modify the app’s initialization code so it selects that class when appropriate.

##### Code Example

![Abstract](images/Abstract.png)

* Code

(https://github.com/Sharath424/Design-Pattern/tree/main/Abstract%20Factory/Abstract/src)

* OutputDemo:

```
You create WindowsButton.
You created WindowsCheckbox.

```


#### Builder


![Builder](images/Builder.png)


Builder is a creational design pattern, which allows constructing complex objects step by step.

Unlike other creational patterns, Builder doesn’t require products to have a common interface. That makes it possible to produce different products using the same construction process.


##### Pseudocode

This example of the Builder pattern illustrates how you can reuse the same object construction code when building different types of products, such as cars, and create the corresponding manuals for them.

A car is a complex object that can be constructed in a hundred different ways. Instead of bloating the Car class with a huge constructor, we extracted the car assembly code into a separate car builder class. This class has a set of methods for configuring various parts of a car.

If the client code needs to assemble a special, fine-tuned model of a car, it can work with the builder directly. On the other hand, the client can delegate the assembly to the director class, which knows how to use a builder to construct several of the most popular models of cars.

You might be shocked, but every car needs a manual (seriously, who reads them?). The manual describes every feature of the car, so the details in the manuals vary across the different models. That’s why it makes sense to reuse an existing construction process for both real cars and their respective manuals. Of course, building a manual isn’t the same as building a car, and that’s why we must provide another builder class that specializes in composing manuals. This class implements the same building methods as its car-building sibling, but instead of crafting car parts, it describes them. By passing these builders to the same director object, we can construct either a car or a manual.

The final part is fetching the resulting object. A metal car and a paper manual, although related, are still very different things. We can’t place a method for fetching results in the director without coupling the director to concrete product classes. Hence, we obtain the result of the construction from the builder which performed the job.


##### Code Example

![Builder](images/Builder-example.png)

* Code

(https://github.com/Sharath424/Design-Pattern/tree/main/Builder/Builder/src)

* Output

```
Car built:
SPORTS_CAR

Car manual built:
Type of car: SPORTS_CAR
Count of seats: 2
Engine: volume - 3.0; mileage - 0.0
Transmission: SEMI_AUTOMATIC
Trip Computer: Functional
GPS Navigator: Functional

```

#### Prototype

Prototype is a creational design pattern that allows cloning objects, even complex ones, without coupling to their specific classes.

All prototype classes should have a common interface that makes it possible to copy objects even if their concrete classes are unknown. Prototype objects can produce full copies since objects of the same class can access each other’s private fields.

![Prototype](images/Prototype.png)

##### Pseudocode

In this example, the Prototype pattern lets you produce exact copies of geometric objects, without coupling the code to their classes.

All shape classes follow the same interface, which provides a cloning method. A subclass may call the parent’s cloning method before copying its own field values to the resulting object.

##### Code Example

![Prototype](images/Prototype-example.png)

* Code

(https://github.com/Sharath424/Design-Pattern/tree/main/Prototype)

* Output of Prototype:

```
0: Shapes are different objects (yay!)
0: And they are identical (yay!)
1: Shapes are different objects (yay!)
1: And they are identical (yay!)
2: Shapes are different objects (yay!)
2: And they are identical (yay!)
```

* Output of Prototype registry

```
Big green circle != Medium blue rectangle (yay!)
Medium blue rectangles are two different objects (yay!)
And they are identical (yay!)
```

#### Singleton

Singleton is a creational design pattern, which ensures that only one object of its kind exists and provides a single point of access to it for any other code.

Singleton has almost the same pros and cons as global variables. Although they’re super-handy, they break the modularity of your code.

You can’t just use a class that depends on a Singleton in some other context, without carrying over the Singleton to the other context. Most of the time, this limitation comes up during the creation of unit tests.

![Singleton](images/Singleton.png)

##### Code Example

* Code 

(https://github.com/Sharath424/Design-Pattern/tree/main/Singleton)

* Output of DemoSingleThread
```
If you see the same value, then singleton was reused (yay!)
If you see different values, then 2 singletons were created (booo!!)

RESULT:

FOO
FOO

```

* Output of DemoMultiThread

```
If you see the same value, then singleton was reused (yay!)
If you see different values, then 2 singletons were created (booo!!)

RESULT:

FOO
BAR

```
* Output of DemoMultiThread

```
If you see the same value, then singleton was reused (yay!)
If you see different values, then 2 singletons were created (booo!!)

RESULT:

BAR
BAR
```
### Structural Patterns

Structural design patterns are concerned with how classes and objects can be composed, to form larger structures.

The structural design patterns simplifies the structure by identifying the relationships.

These patterns focus on, how the classes inherit from each other and how they are composed from other classes.


Types of structural design patterns

* [Adapter](#adapter) Pattern Adapting an interface into another according to client expectation.

* [Bridge Pattern](#bridge) Separating abstraction (interface) from implementation.

* [Composite Pattern](#composite) Allowing clients to operate on hierarchy of objects.

* [Facade Pattern](#facade) Providing an interface to a set of interfaces.

* [Flyweight Pattern](#flyweight) Reusing an object by sharing it.

* [proxy Pattern](#proxy) Representing another object.


#### Adapter
Adapter is a structural design pattern, which allows incompatible objects to collaborate.

The Adapter acts as a wrapper between two objects. It catches calls for one object and transforms them to format and interface recognizable by the second object.

![Adapter](images/Adapter.png)

##### Code Example

![Adapter](images/Code-example.png)

* Code

(https://github.com/Sharath424/Design-Pattern/tree/main/Adapter/adapter/src)

* Output

```
Round peg r5 fits round hole r5.
Square peg w2 fits round hole r5.
Square peg w20 does not fit into round hole r5.

```

#### Bridge

Bridge is a structural design pattern that divides business logic or huge class into separate class hierarchies that can be developed independently.

One of these hierarchies (often called the Abstraction) will get a reference to an object of the second hierarchy (Implementation). The abstraction will be able to delegate some (sometimes, most) of its calls to the implementations object. Since all implementations will have a common interface, they’d be interchangeable inside the abstraction.

![Bridge](images/Bridge.png)

##### Pseudocode

This example illustrates how the Bridge pattern can help divide the monolithic code of an app that manages devices and their remote controls. The Device classes act as the implementation, whereas the Remotes act as the abstraction.

The base remote control class declares a reference field that links it with a device object. All remotes work with the devices via the general device interface, which lets the same remote support multiple device types.

You can develop the remote control classes independently from the device classes. All that’s needed is to create a new remote subclass. For example, a basic remote control might only have two buttons, but you could extend it with additional features, such as an extra battery or a touchscreen.

The client code links the desired type of remote control with a specific device object via the remote’s constructor.

##### Code Example

![Bridge](images/Builder-example.png)

* Code

(https://github.com/Sharath424/Design-Pattern/tree/main/Bridge/bridge/src)

* Output

```
Tests with basic remote.
Remote: power toggle
------------------------------------
| I'm TV set.
| I'm enabled
| Current volume is 30%
| Current channel is 1
------------------------------------

Tests with advanced remote.
Remote: power toggle
Remote: mute
------------------------------------
| I'm TV set.
| I'm disabled
| Current volume is 0%
| Current channel is 1
------------------------------------

Tests with basic remote.
Remote: power toggle
------------------------------------
| I'm radio.
| I'm enabled
| Current volume is 30%
| Current channel is 1
------------------------------------

Tests with advanced remote.
Remote: power toggle
Remote: mute
------------------------------------
| I'm radio.
| I'm disabled
| Current volume is 0%
| Current channel is 1
------------------------------------
```

#### Composite

Composite is a structural design pattern that allows composing objects into a tree-like structure and work with the it as if it was a singular object.

Composite became a pretty popular solution for the most problems that require building a tree structure. Composite’s great feature is the ability to run methods recursively over the whole tree structure and sum up the results.

![Composite](images/Composite.png)

##### Pseudocode


The CompoundGraphic class is a container that can comprise any number of sub-shapes, including other compound shapes. A compound shape has the same methods as a simple shape. However, instead of doing something on its own, a compound shape passes the request recursively to all its children and “sums up” the result.

The client code works with all shapes through the single interface common to all shape classes. Thus, the client doesn’t know whether it’s working with a simple shape or a compound one. The client can work with very complex object structures without being coupled to concrete classes that form that structure.

##### Code Example

![Composite](images/Composite-code-example.png)

* Code

(https://github.com/Sharath424/Design-Pattern/tree/main/Composite/Composite/src)

* Output

![Composite](images/Composite-output.png)


#### Facade

Facade is a structural design pattern that provides a simplified (but limited) interface to a complex system of classes, library or framework.

While Facade decreases the overall complexity of the application, it also helps to move unwanted dependencies to one place.

![Facade](images/Facade.png)

##### Pseudocode

In this example, the Facade pattern simplifies interaction with a complex video conversion framework.

Instead of making your code work with dozens of the framework classes directly, you create a facade class which encapsulates that functionality and hides it from the rest of the code. This structure also helps you to minimize the effort of upgrading to future versions of the framework or replacing it with another one. The only thing you’d need to change in your app would be the implementation of the facade’s methods.

##### Code Example

![Facade](images/facade-code-example.png)

* Code

(https://github.com/Sharath424/Design-Pattern/tree/main/Facade/Facade/src)


* Output

```
VideoConversionFacade: conversion started.
CodecFactory: extracting ogg audio...
BitrateReader: reading file...
BitrateReader: writing file...
AudioMixer: fixing audio...
VideoConversionFacade: conversion completed.
```
#### Flyweight

Flyweight is a structural design pattern that allows programs to support vast quantities of objects by keeping their memory consumption low.

The pattern achieves it by sharing parts of object state between multiple objects. In other words, the Flyweight saves RAM by caching the same data used by different objects.

![flyweight](images/flyweight.png)

##### Pseudocode

In this example, the Flyweight pattern helps to reduce memory usage when rendering millions of tree objects on a canvas.

The pattern extracts the repeating intrinsic state from a main Tree class and moves it into the flyweight class TreeType.

Now instead of storing the same data in multiple objects, it’s kept in just a few flyweight objects and linked to appropriate Tree objects which act as contexts. The client code creates new tree objects using the flyweight factory, which encapsulates the complexity of searching for the right object and reusing it if needed.

##### Code Example

![flyweight](images/Flyweight-code-example.png)

* Code

(https://github.com/Sharath424/Design-Pattern/tree/main/Flyweight/Flyweight/src)

* output

![flyweight](images/flyweight-output.png)

#### Proxy

Proxy is a structural design pattern that provides an object that acts as a substitute for a real service object used by a client. A proxy receives client requests, does some work (access control, caching, etc.) and then passes the request to a service object.

The proxy object has the same interface as a service, which makes it interchangeable with a real object when passed to a client.

![proxy](images/proxy.png)

##### Pseudocode

This example illustrates how the Proxy pattern can help to introduce lazy initialization and caching to a 3rd-party YouTube integration library.

The library provides us with the video downloading class. However, it’s very inefficient. If the client application requests the same video multiple times, the library just downloads it over and over, instead of caching and reusing the first downloaded file.

The proxy class implements the same interface as the original downloader and delegates it all the work. However, it keeps track of the downloaded files and returns the cached result when the app requests the same video multiple times.

##### Code Example

![proxy](images/proxy-code-example.png)

* Code

(https://github.com/Sharath424/Design-Pattern/tree/main/Proxy/Proxy/src)

* Output

```
Connecting to http://www.youtube.com... Connected!
Downloading populars... Done!

-------------------------------
Most popular videos on YouTube (imagine fancy HTML)
ID: sadgahasgdas / Title: Catzzzz.avi
ID: asdfas3ffasd / Title: Dancing video.mpq
ID: 3sdfgsd1j333 / Title: Programing lesson#1.avi
ID: mkafksangasj / Title: Dog play with ball.mp4
ID: dlsdk5jfslaf / Title: Barcelona vs RealM.mov
-------------------------------

Connecting to http://www.youtube.com/catzzzzzzzzz... Connected!
Downloading video... Done!

-------------------------------
Video page (imagine fancy HTML)
ID: catzzzzzzzzz
Title: Some video title
Video: Random video.
-------------------------------

Connecting to http://www.youtube.com... Connected!
Downloading populars... Done!

-------------------------------
Most popular videos on YouTube (imagine fancy HTML)
ID: sadgahasgdas / Title: Catzzzz.avi
ID: asdfas3ffasd / Title: Dancing video.mpq
ID: 3sdfgsd1j333 / Title: Programing lesson#1.avi
ID: mkafksangasj / Title: Dog play with ball.mp4
ID: dlsdk5jfslaf / Title: Barcelona vs RealM.mov
-------------------------------

Connecting to http://www.youtube.com/dancesvideoo... Connected!
Downloading video... Done!

-------------------------------
Video page (imagine fancy HTML)
ID: dancesvideoo
Title: Some video title
Video: Random video.
-------------------------------

Connecting to http://www.youtube.com/catzzzzzzzzz... Connected!
Downloading video... Done!

-------------------------------
Video page (imagine fancy HTML)
ID: catzzzzzzzzz
Title: Some video title
Video: Random video.
-------------------------------

Connecting to http://www.youtube.com/someothervid... Connected!
Downloading video... Done!

-------------------------------
Video page (imagine fancy HTML)
ID: someothervid
Title: Some video title
Video: Random video.
-------------------------------

Time elapsed: 9354ms
Connecting to http://www.youtube.com... Connected!
Downloading populars... Done!

-------------------------------
Most popular videos on YouTube (imagine fancy HTML)
ID: sadgahasgdas / Title: Catzzzz.avi
ID: asdfas3ffasd / Title: Dancing video.mpq
ID: 3sdfgsd1j333 / Title: Programing lesson#1.avi
ID: mkafksangasj / Title: Dog play with ball.mp4
ID: dlsdk5jfslaf / Title: Barcelona vs RealM.mov
-------------------------------

Connecting to http://www.youtube.com/catzzzzzzzzz... Connected!
Downloading video... Done!

-------------------------------
Video page (imagine fancy HTML)
ID: catzzzzzzzzz
Title: Some video title
Video: Random video.
-------------------------------

Retrieved list from cache.

-------------------------------
Most popular videos on YouTube (imagine fancy HTML)
ID: sadgahasgdas / Title: Catzzzz.avi
ID: asdfas3ffasd / Title: Dancing video.mpq
ID: 3sdfgsd1j333 / Title: Programing lesson#1.avi
ID: mkafksangasj / Title: Dog play with ball.mp4
ID: dlsdk5jfslaf / Title: Barcelona vs RealM.mov
-------------------------------

Connecting to http://www.youtube.com/dancesvideoo... Connected!
Downloading video... Done!

-------------------------------
Video page (imagine fancy HTML)
ID: dancesvideoo
Title: Some video title
Video: Random video.
-------------------------------

Retrieved video 'catzzzzzzzzz' from cache.

-------------------------------
Video page (imagine fancy HTML)
ID: catzzzzzzzzz
Title: Some video title
Video: Random video.
-------------------------------

Connecting to http://www.youtube.com/someothervid... Connected!
Downloading video... Done!

-------------------------------
Video page (imagine fancy HTML)
ID: someothervid
Title: Some video title
Video: Random video.
-------------------------------

Time elapsed: 6875ms
Time saved by caching proxy: 4479ms

```


### Behavioral Patterns

Behavioral design patterns are concerned with the interaction and responsibility of objects.

In these design patterns, the interaction between the objects should be in such a way that they can easily talk to each other and still should be loosely coupled.

That means the implementation and the client should be loosely coupled in order to avoid hard coding and dependencies.


There are 10 types of behavioral design patterns:

* [Chain of Responsibility Pattern](#chain-of-responsibility)

* [Command Pattern](#command)

* [Iterator Pattern](#iterator)

* [Mediator Pattern](#mediator)

* [Memento Pattern](#memento)

* [Observer Pattern](#observer)

* [State Pattern](#state)

* [Strategy Pattern](#strategy)

* [Template Pattern](#template-method)

* [visitor](#visitor)

#### Chain of Responsibility
Chain of Responsibility is behavioral design pattern that allows passing request along the chain of potential handlers until one of them handles request.

The pattern allows multiple objects to handle the request without coupling sender class to the concrete classes of the receivers. The chain can be composed dynamically at runtime with any handler that follows a standard handler interface.

![chain-of-responsibity](images/Chai-of-responsibity.png)


##### Pseudocode

In this example, the Chain of Responsibility pattern is responsible for displaying contextual help information for active GUI elements.

The application’s GUI is usually structured as an object tree. For example, the Dialog class, which renders the main window of the app, would be the root of the object tree. The dialog contains Panels, which might contain other panels or simple low-level elements like Buttons and TextFields.

A simple component can show brief contextual tooltips, as long as the component has some help text assigned. But more complex components define their own way of showing contextual help, such as showing an excerpt from the manual or opening a page in a browser.

When a user points the mouse cursor at an element and presses the F1 key, the application detects the component under the pointer and sends it a help request. The request bubbles up through all the element’s containers until it reaches the element that’s capable of displaying the help information.

![chain-of-responsibity](images/Chain-of-responsibity-pes.png)

##### Code Example

![chain-of-responsibity](images/chain-of-responsibity-code.png)

* Code

(https://github.com/Sharath424/Design-Pattern/tree/main/Chain%20of%20Responsibility/Chain_of_Responsibility/src)

* Output

```
Enter email: admin@example.com
Input password: admin_pass
Hello, admin!
Authorization have been successful!


Enter email: wrong@example.com
Input password: wrong_pass
This email is not registered!
Enter email: wrong@example.com
Input password: wrong_pass
This email is not registered!
Enter email: wrong@example.com
Input password: wrong_pass
Request limit exceeded!

```

#### Command

Command is behavioral design pattern that converts requests or simple operations into objects.

The conversion allows deferred or remote execution of commands, storing command history, etc.

![Command](images/command.png)

##### Pseudocode

In this example, the Command pattern helps to track the history of executed operations and makes it possible to revert an operation if needed.

Commands which result in changing the state of the editor (e.g., cutting and pasting) make a backup copy of the editor’s state before executing an operation associated with the command. After a command is executed, it’s placed into the command history (a stack of command objects) along with the backup copy of the editor’s state at that point. Later, if the user needs to revert an operation, the app can take the most recent command from the history, read the associated backup of the editor’s state, and restore it.

The client code (GUI elements, command history, etc.) isn’t coupled to concrete command classes because it works with commands via the command interface. This approach lets you introduce new commands into the app without breaking any existing code.


##### Output

![command](images/command-code-example.png)

* Code

(https://github.com/Sharath424/Design-Pattern/tree/main/Command/commands/src)

* output

![command](images/command-output.png)

#### Iterator


Iterator is a behavioral design pattern that allows sequential traversal through a complex data structure without exposing its internal details.

Thanks to the Iterator, clients can go over elements of different collections in a similar fashion using a single iterator interface.

![iterator](images/iterator.png)

##### Pseudocode

In this example, the Iterator pattern is used to walk through a special kind of collection which encapsulates access to Facebook’s social graph. The collection provides several iterators that can traverse profiles in various ways.

The ‘friends’ iterator can be used to go over the friends of a given profile. The ‘colleagues’ iterator does the same, except it omits friends who don’t work at the same company as a target person. Both iterators implement a common interface which allows clients to fetch profiles without diving into implementation details such as authentication and sending REST requests.

The client code isn’t coupled to concrete classes because it works with collections and iterators only through interfaces. If you decide to connect your app to a new social network, you simply need to provide new collection and iterator classes without changing the existing code.

##### Code Example

![iterator](images/iterator-code-example.png)

* Code

(https://github.com/Sharath424/Design-Pattern/tree/main/Iterators/Iterators/src)

* Output

```
Please specify social network to target spam tool (default:Facebook):
1. Facebook
2. LinkedIn
> 1

Iterating over friends...

Facebook: Loading 'friends' list of 'anna.smith@bing.com' over the network...
Facebook: Loading profile 'mad_max@ya.com' over the network...
Sent message to: 'mad_max@ya.com'. Message body: 'Hey! This is Anna's friend Josh. Can you do me a favor and like this post [link]?'
Facebook: Loading profile 'catwoman@yahoo.com' over the network...
Sent message to: 'catwoman@yahoo.com'. Message body: 'Hey! This is Anna's friend Josh. Can you do me a favor and like this post [link]?'

Iterating over coworkers...

Facebook: Loading 'coworkers' list of 'anna.smith@bing.com' over the network...
Facebook: Loading profile 'sam@amazon.com' over the network...
Sent message to: 'sam@amazon.com'. Message body: 'Hey! This is Anna's boss Jason. Anna told me you would be interested in [link].'
```

#### Mediator

Mediator is a behavioral design pattern that reduces coupling between components of a program by making them communicate indirectly, through a special mediator object.

The Mediator makes it easy to modify, extend and reuse individual components because they’re no longer dependent on the dozens of other classes.

![Mediator](images/mediator.png)

##### Pseudocode

In this example, the Mediator pattern helps you eliminate mutual dependencies between various UI classes: buttons, checkboxes and text labels.

An element, triggered by a user, doesn’t communicate with other elements directly, even if it looks like it’s supposed to. Instead, the element only needs to let its mediator know about the event, passing any contextual info along with that notification.

In this example, the whole authentication dialog acts as the mediator. It knows how concrete elements are supposed to collaborate and facilitates their indirect communication. Upon receiving a notification about an event, the dialog decides what element should address the event and redirects the call accordingly.

##### Code Example

![mediator](images/mediator-code-example.png)

* Code

(https://github.com/Sharath424/Design-Pattern/tree/main/Mediator/Mediator/src)

* Output

![mediator](images/mediator-output.png)

#### Memento

Memento is a behavioral design pattern that allows making snapshots of an object’s state and restoring it in future.

The Memento doesn’t compromise the internal structure of the object it works with, as well as data kept inside the snapshots.

![memento](images/memento.png)

##### Pseudocode

This example uses the Memento pattern alongside the Command pattern for storing snapshots of the complex text editor’s state and restoring an earlier state from these snapshots when needed.

The command objects act as caretakers. They fetch the editor’s memento before executing operations related to commands. When a user attempts to undo the most recent command, the editor can use the memento stored in that command to revert itself to the previous state.

The memento class doesn’t declare any public fields, getters or setters. Therefore no object can alter its contents. Mementos are linked to the editor object that created them. This lets a memento restore the linked editor’s state by passing the data via setters on the editor object. Since mementos are linked to specific editor objects, you can make your app support several independent editor windows with a centralized undo stack.

##### Code Example

![memento](images/mediator-code-example.png)

* Code

(https://github.com/Sharath424/Design-Pattern/tree/main/Mediator/Mediator/src)

* Output

![memento](images/mediator-output.png)

#### Observer

Observer is a behavioral design pattern that allows some objects to notify other objects about changes in their state.

The Observer pattern provides a way to subscribe and unsubscribe to and from these events for any object that implements a subscriber interface.

![observer](images/Observer.png)

##### Pseudocode

In this example, the Observer pattern lets the text editor object notify other service objects about changes in its state.

The list of subscribers is compiled dynamically: objects can start or stop listening to notifications at runtime, depending on the desired behavior of your app.

In this implementation, the editor class doesn’t maintain the subscription list by itself. It delegates this job to the special helper object devoted to just that. You could upgrade that object to serve as a centralized event dispatcher, letting any object act as a publisher.

Adding new subscribers to the program doesn’t require changes to existing publisher classes, as long as they work with all subscribers through the same interface.


##### Code Example

![observer](images/observer-code-example.png)

* Code

(https://github.com/Sharath424/Design-Pattern/tree/main/observer/Observer/src)

* Output

```
Save to log \path\to\log\file.txt: Someone has performed open operation with the following file: test.txt
Email to admin@example.com: Someone has performed save operation with the following file: test.txt
```

#### State

State is a behavioral design pattern that allows an object to change the behavior when its internal state changes.

The pattern extracts state-related behaviors into separate state classes and forces the original object to delegate the work to an instance of these classes, instead of acting on its own.

![State](images/State.png)

##### Pseudocode

In this example, the State pattern lets the same controls of the media player behave differently, depending on the current playback state.

The main object of the player is always linked to a state object that performs most of the work for the player. Some actions replace the current state object of the player with another, which changes the way the player reacts to user interactions.

##### Code Example

![state](images/State-code-example.png)

* Code

(https://github.com/Sharath424/Design-Pattern/tree/main/States/States/src)

* Output

![state](images/State-output.png)

#### Strategy

Strategy is a behavioral design pattern that turns a set of behaviors into objects and makes them interchangeable inside original context object.

The original object, called context, holds a reference to a strategy object. The context delegates executing the behavior to the linked strategy object. In order to change the way the context performs its work, other objects may replace the currently linked strategy object with another one.

![strategy](images/strategy.png)

##### Code Example

* Code

(https://github.com/Sharath424/Design-Pattern/tree/main/Strategy/Strategy/src)


* Output

![strategy](images/strategy-output.png)


#### Template Method

Template Method is a behavioral design pattern that allows you to defines a skeleton of an algorithm in a base class and let subclasses override the steps without changing the overall algorithm’s structure.

![template](images/template.png)

##### Pseudocode

In this example, the Template Method pattern provides a “skeleton” for various branches of artificial intelligence in a simple strategy video game.


All races in the game have almost the same types of units and buildings. Therefore you can reuse the same AI structure for various races, while being able to override some of the details. With this approach, you can override the orcs’ AI to make it more aggressive, make humans more defense-oriented, and make monsters unable to build anything. Adding a new race to the game would require creating a new AI subclass and overriding the default methods declared in the base AI class.

![template](images/template-struc.png)


##### Code Example

* Code

(https://github.com/Sharath424/Design-Pattern/tree/main/Template/Template)

* Output

![template](images/template-output.png)


#### Visitor

Visitor is a behavioral design pattern that allows adding new behaviors to existing class hierarchy without altering any existing code.

![cisitor](images/visitor.png)

##### Pseudocode

![visitor](images/visitor-structure.png)

##### Code Example

* Code

(https://github.com/Sharath424/Design-Pattern/tree/main/Visitor/Visitor/src)

* Output

![visitor](images/visitor-output.png)


### MVC

The Model View Controller (MVC) design pattern specifies that an application consist of a data model, presentation information, and control information. The pattern requires that each of these be separated into different objects. MVC is more of an architectural pattern, but not for complete application. MVC mostly relates to the UI / interaction layer of an application. You’re still going to need business logic layer, maybe some service layer and data access layer. 

* The Model contains only the pure application data, it contains no logic describing how to present the data to a user. (Its just a data that is shipped across the application like for example from back-end server view and from front-end view to the database. In java programming, Model can be represented by the use of POJO (Plain-old-java-object) which is a simple java class.

* The View presents the model’s data to the user. The view knows how to access the model’s data, but it does not know what this data means or what the user can do to manipulate it. View just represent, displays the application’s data on screen. View page are generally in the format of .html or .jsp in java programming (which is flexible).

* The Controller exists between the view and the model. It is where the actual business logic is written. It listens to events triggered by the view (or another external source) and executes the appropriate reaction to these events. In most cases, the reaction is to call a method on the model. Since the view and the model are connected through a notification mechanism, the result of this action is then automatically reflected in the view.

![MVC](images/mvc.png)


* Code Example

(https://github.com/Sharath424/Design-Pattern/tree/main/MVC)

#### Advantages and Disadvantages

1. Advantage

* Multiple developers can work simultaneously on the model, controller and views.

* MVC enables logical grouping of related actions on a controller together. The views for a specific model are also grouped together.

* Models can have multiple views.

* The overall components of an application are easily manageable & are less dependent on each other for proper functioning of application.

2. Disadvantage

* The framework navigation can be complex because it introduces new layers of abstraction and requires users to adapt to the decomposition criteria of MVC.

* Knowledge on multiple technologies becomes the norm. Developers using MVC need to be skilled in multiple technologies.

### Commit ids

* [Factory Pattern](#factory-method) - cc519bcffb06e89299973277f44292dd0fc8f49e

* [Abstract Factory Pattern](#abstract-factory) - 0f6888f6753001d3df25e8dfe5dda26e1e8e50c9 

* [Singleton Pattern](#singleton) - e8d89f3112db9e0e2658034f04cb553769b7447b

* [Prototype Pattern](#prototype) - b046101daa4a4a2bc7fa6f2ffed69bcf664c092c

* [Builder Pattern](#builder) - c2b9a45df01b57fc4614ee6c17604f28295569ae

* [Adapter Pattern](#adapter) - 23159d6ddbc54886711681e174179355e77866d1

* [Bridge Pattern](#bridge) - 773d1624d63e58d88846df57c5ce4e48ea86c52e

* [Composite Pattern](#composite) - 27702d2e9841f6773898cb87f1a0d724c75b324d

* [Facade Pattern](#facade) - d0c947484ba24844ae927072a283449e9d9a99da

* [Flyweight Pattern](#flyweight) - da730801be663b7551636a207d5df2bda6164d3d

* [Proxy Pattern](#proxy) - 667f32e94e05282df3fa5b1081db5b94dfac140d

* [Chain Of Responsibility Pattern](#chain-of-responsibility) -ed531d99c2cf19fbda7990efedd4d9c1c98a5f44

* [Command Pattern](#command) - dc3a8bbb3e07eeaa731a91b80a58181e730241fa

* [Iterator Pattern](#iterator) - 055fe4e630c424f30acd24c7514fa06b29677f33

* [Mediator Pattern](#mediator) - 5e8d457ab01d6d12260f4556ec01a3f43570bac6

* [Memento Pattern](#memento)- ba22ccbf0119f7fd84427db75fdd421757862de4

* [Observer Pattern](#observer)- 24386b818f0ac125c1b959e6f8760edf8aaa6a2b

* [State Pattern](#state) - 8f69e99108abf4866c162f9df209bcb9c52802b0

* [Strategy Pattern](#strategy) - 40736b38e60ee79e702368e33bf60794af2b189e

* [Template Pattern](#template-method)- 34dad4e6709b07bb76ae2c099fb32b7efe394c9f

* [visitor](#visitor)- 444b3446d4ae7f89ee617f093ee150aa126caa4c