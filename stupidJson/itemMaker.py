def main():
    print("Please enter filename:")
    filename = input()
    f = open('..\\src\\main\\resources\\assets\\forbidden\\models\\item\\' + filename + '.json', mode='xt')

    f.write('{\n')
    f.write('  "parent": "forbidden:item/base_item",\n')
    f.write('  "textures": {\n')
    f.write('    "layer0": "forbidden:items/' + filename + '"\n')
    f.write('  }\n')
    f.write('}')
    f.close()

main()
