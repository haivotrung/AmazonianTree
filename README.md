# AmazonianTree

On Amazonia (where Wonder Woman is from), there are only women.  They reproduce through clay figurines – that is, when an Amazon wants to have a daughter she molds a clay figurine and adopts it, after which the figurine turns into a baby girl.  As such, Amazonians only have one parent.

Although there are no fathers, brothers, uncles, etc. on Amazonia, there are still parents, ancestors, descendants, sisters, etc. to keep track of.  Hippolyta, Queen of the Amazons, wants a program to keep track of all these relationships.

The program will accept commands from a user. There will be one command per line, in the form: *verb* *object* *relation* *target*
<ul>

<li> relation and target are optional, as described below.</li>
<li> verb is one of “create”, “set” , “get” , “is”, or “count”.</li>
<li> object is an Amazonian’s name.  Each Amazonian has a unique name.</li>
<li> relation is one of “parent”, “child”, “sister”, “ancestor”, “descendant”.</li>
<li> target is an Amazonian’s name.</li>


</ul>



Create: create <name>	
     Creates <name> as an Amazonian who can be referred to in other commands.  If <name> is not created, referring to it in later commands is an error.
Examples

create Diana	Creates an Amazonian named “Diana”.
create Hippolyta	Creates an Amazonian named “Hippolyta”.
create Nubia	Creates an Amazonian named “Nubia”.


Set: set <name> <relation> <target>	
    Sets the relationship between name and target.  The only valid relations in a set command are “parent” and “child”.
Examples

set Hippolyta parent Diana	Sets Hippolyta as the parent of Diana.
set Hippolyta parent Nubia	Sets Hippolyta as the parent of Nubia


Get: get <name> <relation>	Prints out a list of all Amazonians that have <relation> to <name>.
Examples

get Diana parent	Prints out “Hippolyta”
get Hippolyta child	Prints out “Diana” and “Nubia”
get Nubia child	Prints out “none”


Is: is <name> <relation> <target>	Prints out True if <name> has <relation> to <target>, False otherwise.
Examples

is Diana parent Nubia	Prints out “False”
is Diana sister Nubia	Prints out “True”


Count: count <name> <relation>	Prints out the number of Amazonians that <name> has <relation> with.
Examples

count Hippolyta child	Prints out “2”
count Diana descendant	Prints out “0”



<b>Notes</b>:
1.	If a user sets Shirley to be Diana’s parent, the user must not be required to set Diana as Shirley’s child.  Diana is Shirley’s child, but the user need not enter that explicitly.
2.	Descendants are children, grandchildren, etc.  Ancestors are parents, grandparents, etc.
3.	If A and B have the same parent, A and B are sisters.
4.	Sisterhood is transitive.  If A is sister to B, and B is sister to C, A is sister to C.
5.	All Amazonians use exactly one name, and those names contain only characters.
6.	No Amazonian is named “none”.
7.	If A is B’s parent, and the user later enters that C is B’s parent, then from that point on C is B’s parent.
8.	Aphrodite is the ultimate ancestor of every Amazonian, and she has no parent.  The user need not create her.

<b>Constraints</b>:
1.	Parent-child relationships are non-circular.  For example, if A is B’s parent, and B is C’s parent, C may not be A’s parent.
2.	A cannot be both sister and mother to B.
3.	Both of these cannot be true: A is sister to B, B is mother to A.
4.	Amazonian names are unique.
