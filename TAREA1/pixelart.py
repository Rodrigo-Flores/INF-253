import re
import numpy as np
# import PIL

# [A-Z][a-z]+(\s\d+\s[a-z]+|\s[a-z]+\s[a-z]+|\s\d+)?

with open("test-regex.txt", "r") as file:
    t = file.read()
    comandos = re.split(r"\n", t)
    comandos_limpios = []
    for i in comandos:
        comandos_limpios.append([x for x in re.split(r"(\W)", i) if x not in ["", " "]])
        # print([x for x in re.split(r"(\W)", i) if x not in ["", " "]])

for i in comandos_limpios:
    print(i)