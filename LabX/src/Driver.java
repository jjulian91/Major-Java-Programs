   i   m   p   o   r   t       j   a   v   a   .   u   t   i   l   .   S   t   a   c   k   ;      
      
   p   u   b   l   i   c       c   l   a   s   s       D   r   i   v   e   r       {      
   	   p   u   b   l   i   c       s   t   a   t   i   c       v   o   i   d       m   a   i   n   (   S   t   r   i   n   g   [   ]       a   r   g   s   )       {      
      
   	   	   /   /       c   r   e   a   t   e       a       g   r   a   p   h       l   i   k   e       t   h   e       o   n   e       L   a   b   X   E   x   a   m   p   l   e   ,       b   u   t       w   i   t   h   o   u   t       t   h   e       e   d   g   e       h   i   g   h   l   i   g   h   t   e   d       i   n       r   e   d      
   	   	   /   /       t   h   e       g   r   a   p   h       i   s       d   i   s   c   o   n   n   e   c   t   e   d      
   	   	   U   n   d   i   r   e   c   t   e   d   G   r   a   p   h   <   S   t   r   i   n   g   >       n   u   m   b   e   r   M   a   p       =       n   e   w       U   n   d   i   r   e   c   t   e   d   G   r   a   p   h   <   S   t   r   i   n   g   >   (   )   ;      
   	   	   n   u   m   b   e   r   M   a   p   .   a   d   d   V   e   r   t   e   x   (   "   0   "   )   ;      
   	   	   n   u   m   b   e   r   M   a   p   .   a   d   d   V   e   r   t   e   x   (   "   1   "   )   ;      
   	   	   n   u   m   b   e   r   M   a   p   .   a   d   d   V   e   r   t   e   x   (   "   2   "   )   ;      
   	   	   n   u   m   b   e   r   M   a   p   .   a   d   d   V   e   r   t   e   x   (   "   3   "   )   ;      
   	   	   n   u   m   b   e   r   M   a   p   .   a   d   d   V   e   r   t   e   x   (   "   4   "   )   ;      
   	   	   n   u   m   b   e   r   M   a   p   .   a   d   d   V   e   r   t   e   x   (   "   5   "   )   ;      
   	   	   n   u   m   b   e   r   M   a   p   .   a   d   d   V   e   r   t   e   x   (   "   6   "   )   ;      
      
   	   	   n   u   m   b   e   r   M   a   p   .   a   d   d   E   d   g   e   (   "   0   "   ,       "   1   "   )   ;      
   	   	   n   u   m   b   e   r   M   a   p   .   a   d   d   E   d   g   e   (   "   3   "   ,       "   1   "   )   ;      
   	   	   n   u   m   b   e   r   M   a   p   .   a   d   d   E   d   g   e   (   "   2   "   ,       "   1   "   )   ;      
   	   	   n   u   m   b   e   r   M   a   p   .   a   d   d   E   d   g   e   (   "   2   "   ,       "   3   "   )   ;      
   	   	   n   u   m   b   e   r   M   a   p   .   a   d   d   E   d   g   e   (   "   4   "   ,       "   6   "   )   ;      
   	   	   n   u   m   b   e   r   M   a   p   .   a   d   d   E   d   g   e   (   "   6   "   ,       "   5   "   )   ;      
      
   	   	   S   y   s   t   e   m   .   o   u   t   .   p   r   i   n   t   l   n   (   "   T   h   e   r   e       s   h   o   u   l   d       b   e       7       v   e   r   t   i   c   e   s   :       "       +       n   u   m   b   e   r   M   a   p   .   g   e   t   N   u   m   b   e   r   O   f   V   e   r   t   i   c   e   s   (   )   )   ;      
   	   	   S   y   s   t   e   m   .   o   u   t   .   p   r   i   n   t   l   n   (   "   T   h   e   r   e       s   h   o   u   l   d       b   e       6       e   d   g   e   s   :       "       +       n   u   m   b   e   r   M   a   p   .   g   e   t   N   u   m   b   e   r   O   f   E   d   g   e   s   (   )   )   ;      
      
   	   	   S   y   s   t   e   m   .   o   u   t   .   p   r   i   n   t   l   n   (   "   B   r   e   a   d   t   h   -   F   i   r   s   t       s   t   a   r   t   i   n   g       a   t       0       s   h   o   u   l   d       b   e       \   n   [   0   ,       1   ,       3   ,       2   ]   "   )   ;      
   	   	   S   y   s   t   e   m   .   o   u   t   .   p   r   i   n   t   l   n   (   n   u   m   b   e   r   M   a   p   .   g   e   t   B   r   e   a   d   t   h   F   i   r   s   t   T   r   a   v   e   r   s   a   l   (   "   0   "   )   )   ;      
   	   	   S   y   s   t   e   m   .   o   u   t   .   p   r   i   n   t   l   n   (   "   B   r   e   a   d   t   h   -   F   i   r   s   t       s   t   a   r   t   i   n   g       a   t       6       s   h   o   u   l   d       b   e       \   n   [   6   ,       4   ,       5   ]   "   )   ;      
   	   	   S   y   s   t   e   m   .   o   u   t   .   p   r   i   n   t   l   n   (   n   u   m   b   e   r   M   a   p   .   g   e   t   B   r   e   a   d   t   h   F   i   r   s   t   T   r   a   v   e   r   s   a   l   (   "   6   "   )   )   ;      
      
   	   	   S   y   s   t   e   m   .   o   u   t   .   p   r   i   n   t   l   n   (   "   D   e   p   t   h   -   F   i   r   s   t       s   t   a   r   t   i   n   g       a   t       0       s   h   o   u   l   d       b   e       \   n   [   0   ,       1   ,       3   ,       2   ]   "   )   ;      
   	   	   S   y   s   t   e   m   .   o   u   t   .   p   r   i   n   t   l   n   (   n   u   m   b   e   r   M   a   p   .   g   e   t   D   e   p   t   h   F   i   r   s   t   T   r   a   v   e   r   s   a   l   (   "   0   "   )   )   ;      
   	   	   S   y   s   t   e   m   .   o   u   t   .   p   r   i   n   t   l   n   (   "   D   e   p   t   h   -   F   i   r   s   t       s   t   a   r   t   i   n   g       a   t       6       s   h   o   u   l   d       b   e       \   n   [   6   ,       4   ,       5   ]   "   )   ;      
   	   	   S   y   s   t   e   m   .   o   u   t   .   p   r   i   n   t   l   n   (   n   u   m   b   e   r   M   a   p   .   g   e   t   D   e   p   t   h   F   i   r   s   t   T   r   a   v   e   r   s   a   l   (   "   6   "   )   )   ;      
      
   	   	   S   y   s   t   e   m   .   o   u   t   .   p   r   i   n   t   l   n   (   "   I   s       t   h   i   s       g   r   a   p   h       (   w   i   t   h   o   u   t       r   e   d       l   i   n   e   )       c   o   n   n   e   c   t   e   d       (   s   h   o   u   l   d       b   e       n   o   )   ?       "      
   	   	   	   	   	   	   +       (   n   u   m   b   e   r   M   a   p   .   i   s   C   o   n   n   e   c   t   e   d   (   "   0   "   )       ?       "   y   e   s   "       :       "   n   o   "   )   )   ;      
      
   	   	   /   /       a   d   d       t   h   e       e   d   g   e       h   i   g   h   l   i   s   t   e   d       i   n       r   e   d      
   	   	   /   /       t   h   e       g   r   a   p   h       i   s       n   o   w       c   o   n   n   e   c   t   e   d      
   	   	   n   u   m   b   e   r   M   a   p   .   a   d   d   E   d   g   e   (   "   2   "   ,       "   4   "   )   ;      
   	   	   S   y   s   t   e   m   .   o   u   t   .   p   r   i   n   t   l   n   (   "   T   h   e   r   e       s   h   o   u   l   d       b   e       7       v   e   r   t   i   c   e   s   :       "       +       n   u   m   b   e   r   M   a   p   .   g   e   t   N   u   m   b   e   r   O   f   V   e   r   t   i   c   e   s   (   )   )   ;      
   	   	   S   y   s   t   e   m   .   o   u   t   .   p   r   i   n   t   l   n   (   "   T   h   e   r   e       s   h   o   u   l   d       b   e       7       e   d   g   e   s   :       "       +       n   u   m   b   e   r   M   a   p   .   g   e   t   N   u   m   b   e   r   O   f   E   d   g   e   s   (   )   )   ;      
   	   	   S   y   s   t   e   m   .   o   u   t   .   p   r   i   n   t   l   n   (   "   I   s       t   h   i   s       g   r   a   p   h       (   w   i   t   h       r   e   d       l   i   n   e   )   c   o   n   n   e   c   t   e   d       (   s   h   o   u   l   d       b   e       y   e   s   )   ?       "      
   	   	   	   	   	   	   +       (   n   u   m   b   e   r   M   a   p   .   i   s   C   o   n   n   e   c   t   e   d   (   "   0   "   )       ?       "   y   e   s   "       :       "   n   o   "   )   )   ;      
      
   	   	   S   y   s   t   e   m   .   o   u   t   .   p   r   i   n   t   l   n   (   "   B   r   e   a   d   t   h   -   F   i   r   s   t       s   t   a   r   t   i   n   g       a   t       0       s   h   o   u   l   d       b   e       \   n   [   0   ,       1   ,       3   ,       2   ,       4   ,       6   ,       5   ]   "   )   ;      
   	   	   S   y   s   t   e   m   .   o   u   t   .   p   r   i   n   t   l   n   (   n   u   m   b   e   r   M   a   p   .   g   e   t   B   r   e   a   d   t   h   F   i   r   s   t   T   r   a   v   e   r   s   a   l   (   "   0   "   )   )   ;      
   	   	   S   y   s   t   e   m   .   o   u   t   .   p   r   i   n   t   l   n   (   "   D   e   p   t   h   -   F   i   r   s   t       s   t   a   r   t   i   n   g       a   t       0       s   h   o   u   l   d       b   e       \   n   [   0   ,       1   ,       3   ,       2   ,       4   ,       6   ,       5   ]   "   )   ;      
   	   	   S   y   s   t   e   m   .   o   u   t   .   p   r   i   n   t   l   n   (   n   u   m   b   e   r   M   a   p   .   g   e   t   D   e   p   t   h   F   i   r   s   t   T   r   a   v   e   r   s   a   l   (   "   0   "   )   )   ;      
      
      
      
   	   	   /   /       a   d   d       a   n   o   t   h   e   r       v   e   r   t   e   x       (   n   o   t       s   h   o   w   n       i   n       L   a   b   X   E   x   a   m   p   l   e       p   i   c   t   u   r   e   )      
   	   	   /   /       t   h   e       g   r   a   p   h       i   s       n   o       l   o   n   g   e   r       c   o   n   n   e   c   t   e   d      
   	   	   n   u   m   b   e   r   M   a   p   .   a   d   d   V   e   r   t   e   x   (   "   7   "   )   ;      
   	   	   S   y   s   t   e   m   .   o   u   t   .   p   r   i   n   t   l   n   (   "   T   h   e   r   e       s   h   o   u   l   d       b   e       8       v   e   r   t   i   c   e   s   :       "       +       n   u   m   b   e   r   M   a   p   .   g   e   t   N   u   m   b   e   r   O   f   V   e   r   t   i   c   e   s   (   )   )   ;      
   	   	   S   y   s   t   e   m   .   o   u   t   .   p   r   i   n   t   l   n   (   "   T   h   e   r   e       s   h   o   u   l   d       b   e       7       e   d   g   e   s   :       "       +       n   u   m   b   e   r   M   a   p   .   g   e   t   N   u   m   b   e   r   O   f   E   d   g   e   s   (   )   )   ;      
   	   	   S   y   s   t   e   m   .   o   u   t   .   p   r   i   n   t   l   n   (   "   I   s       t   h   i   s       g   r   a   p   h       c   o   n   n   e   c   t   e   d       n   o   w       (   s   h   o   u   l   d       b   e       n   o   )   ?       "      
   	   	   	   	   	   	   +       (   n   u   m   b   e   r   M   a   p   .   i   s   C   o   n   n   e   c   t   e   d   (   "   0   "   )       ?       "   y   e   s   "       :       "   n   o   "   )   )   ;      
      
   	   	   /   /       w   h   a   t       e   d   g   e       c   o   u   l   d       y   o   u       a   d   d       t   o       m   a   k   e       i   t       c   o   n   n   e   c   t   e   d   ?      
   	   	   /   /       i   s       t   h   e   r   e       m   o   r   e       t   h   a   n       o   n   e       o   p   t   i   o   n   ?       t   e   s   t       i   t       o   u   t   !      
   	   }      
   }      
