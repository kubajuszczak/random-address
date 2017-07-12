# Random Address
Generate almost-convincing English-sounding addresses for use in test data

## What is this?
Have you ever needed a random street name or a town for your test scenario, but completely random characters just won't do? I've got something just for you.

## How does it work?

This uses a Markov chain to try to come up with a word that sounds vaguely English.  A fancy name for a simple idea - take each pair of letters from the words in a large word list (I used [this one](https://github.com/dwyl/english-words)) and count how often you go from a to b, a to c and so on for each letter combination, then use this information to generate a word of given length.

I added some suffixes for extra realism.
 
The program outputs gems such as these:
```
73 Rin Radial, Osoclstead, East Riding of Yorkshire
122 Heril Haven, Termketh, West Sussex
24 Dip Tunnel, Mimidean, Essex
139 Ngier Trail, Ifaeldale, Somerset
128 Estin Meadow, Roncworth, Durham 
170 Dedimun Radial, Enehayes, Merseyside
20 Plinit Run, Stesthwaite, Cornwall
36 Tfda Village, Ysecot, Essex
58 Rak Run, Fepesing, Cambridgeshire
27 Tol Trace, Tenilness, Bedfordshire
73 Wairtra Cape, Nestbost, Northumberland
134 Diceri Village, Abichester, West Yorkshire
123 Luilili Walk, Judsport, Kent
159 Venwer Gateway, Walcarden, Herefordshire
168 Roctow Shoal, Arabost, Cornwall
```

It's not perfect (how do you pronounce Tfda?) but I'm pretty happy with how it turned out.

This project contains two parts - analysing a word list (if you want to try a different word list, or a different language), and generating the address.