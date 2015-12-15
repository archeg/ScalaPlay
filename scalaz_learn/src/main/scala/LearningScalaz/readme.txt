http://eed3si9n.com/learning-scalaz/

I often rewrite comments from the article, which simply helps me to understand them.
Sometimes I rephrase them, sometimes not. In any way in comments "I" means the author of the article,
and not me.

LYAHFGG is the Haskel book author reads.
Haskel code starts with > in comments.

I use shapelesses illTyped to show the code that won't compile, sometimes leaving the
comment how actual error output would've looked like.

And I use a ChapterApp trait which defines some operations that help me structure the code

Notice that === after out() is not scalaz ===, but rather assert opertaion defined in ChapterApp.

this code:
out(1.0 === 2.0) === false
has two different ===: the first one is of scalaz, the second one is provided by ChapterApp