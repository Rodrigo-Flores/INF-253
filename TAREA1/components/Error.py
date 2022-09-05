def write_error(line):
    with open("assets/errors.txt", "a+") as file:
        file.write(line + "\n")
    