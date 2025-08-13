**Is it possible to override the main method?**


NO, because main is a static method. A static method can't be overridden in Java.





**How to invoke a superclass version of an Overridden method?**


To invoke a superclass method that has been overridden in a subclass, you must either call the method directly through a superclass instance, or use the super prefix in the subclass itself. From the point of the view of the subclass, the super prefix provides an explicit reference to the superclass' implementation of the method.



&nbsp;	 // From subclass

&nbsp;		**super**.overriddenMethod(); 





**Do interfaces have member variables?**


Interfaces may have member variables, but these are implicitly public, static, and final- in other words,

&nbsp;interfaces can declare only constants, not instance variables that are available to all implementations and may be used as key references for method arguments for example.





**What modifiers are allowed for methods in an Interface?**


Only public and abstract modifiers are allowed for methods in interfaces.



**What is a marker interface?**


Marker interfaces are those which do not declare any required methods, but signify their compatibility with certain operations. The java.io.Serializable interface and Cloneable are typical marker interfaces. These do not contain any methods, but classes must implement this interface in order to be serialized and de-serialized.

