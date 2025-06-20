# --- Day 4: The Ideal Stocking Stuffer ---

Santa needs help [mining](https://en.wikipedia.org/wiki/Bitcoin#Mining) some AdventCoins (very similar
to [bitcoins](https://en.wikipedia.org/wiki/Bitcoin)) to use as gifts for all the economically forward-thinking little
girls and boys.

To do this, he needs to find [MD5](https://en.wikipedia.org/wiki/MD5) hashes which,
in [hexadecimal](https://en.wikipedia.org/wiki/Hexadecimal), start with at least <code style="color : white">five
zeroes</code>. The input to the MD5 hash is some secret key (your puzzle input, given below) followed by a number in
decimal. To mine AdventCoins, you must find Santa the lowest positive number (no leading zeroes: `1`, `2`, `3`, ...)
that produces such a hash.

For example:

- If your secret key is `abcdef`, the answer is `609043`, because the MD5 hash of `abcdef609043` starts with five
  zeroes (`000001dbbfa...`), and it is the lowest such number to do so.
- If your secret key is `pqrstuv`, the lowest number it combines with to make an MD5 hash starting with five zeroes is
  `1048970`; that is, the MD5 hash of `pqrstuv1048970` looks like `000006136ef...`.

Your puzzle input is `yzbqklnj`.

Your puzzle answer was `282749`.

<code style="color : gold">The first half of this puzzle is complete! It provides one gold star: *</code>

## --- Part Two ---

Now find one that starts with <code style="color : white">six zeroes</code>.

Your puzzle answer was `9962624`.

<code style="color : gold">Both parts of this puzzle are complete! They provide two gold stars: **</code>
