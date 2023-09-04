from math import isnan
from decimal import Decimal

# Nan
a = float("NaN")
print(f"a: {a}")

# Math
print(f"es de tipo nan?: {isnan(a)}")

# Decimal
a = Decimal("Nan")
print(f"es de tipo nan?: {isnan(a)}")
