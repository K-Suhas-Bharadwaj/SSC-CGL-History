from xml.dom import minidom

xmlstr = minidom.parseString(ET.tostring(root)).toprettyxml(indent="   ")
with open("New_Database.xml", "w") as f:
    f.write(xmlstr)
There is one possible complication, especially in Python 2, which is both less strict and less sophisticated about Unicode characters in strings. If your toprettyxml method hands back a Unicode string (u"something"), then you may want to cast it to a suitable file encoding, such as UTF-8. E.g. replace the one write line with:

f.write(xmlstr.encode('utf-8'))
