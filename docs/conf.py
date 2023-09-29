# Configuration file for the Sphinx documentation builder.
#
# For the full list of built-in configuration values, see the documentation:
# https://www.sphinx-doc.org/en/master/usage/configuration.html

import configparser

with open("../gradle.properties", 'r') as f:
    config_string = '[general]\n' + f.read()

gradle_config = configparser.ConfigParser()
gradle_config.read_string(config_string)
gradle_properties = gradle_config['general']

# -- Project information -----------------------------------------------------
# https://www.sphinx-doc.org/en/master/usage/configuration.html#project-information

project = 'Complex Colonists'
copyright = '2023, TagnumElite'
author = 'TagnumElite'
release = gradle_properties['mod_version']


# -- General configuration ---------------------------------------------------
# https://www.sphinx-doc.org/en/master/usage/configuration.html#general-configuration

extensions = []

templates_path = ['_templates']
exclude_patterns = ['_build', 'Thumbs.db', '.DS_Store']


# -- Options for HTML output -------------------------------------------------
# https://www.sphinx-doc.org/en/master/usage/configuration.html#options-for-html-output

html_theme = 'alabaster'
html_static_path = ['_static']

rst_epilog = """
""" + "\n".join([".. |gradle_" + x + "| replace:: " + gradle_properties[x] for x in gradle_properties])

