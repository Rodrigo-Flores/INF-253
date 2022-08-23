import re
import numpy as np
# import PIL

# [A-Z][a-z]+(\s\d+\s[a-z]+|\s[a-z]+\s[a-z]+|\s\d+)?

with open("test-regex.txt", "r") as file:
    t = file.read()
    comandos = re.split(r"\n", t)

    for i in comandos:
        print(re.findall(r"[A-Z][a-z]+", re.sub(r"\s", "", i)))

    # comandos_individuales_sin_espacios = []
    # for comando in comandos_individuales:
    #     comandos_individuales_sin_espacios.append(re.split(r"(\s[A-Z])", comando[0]))

    # for i in comandos_individuales_sin_espacios:
    #     print(i)
