#!/bin/env ruby
require 'json'
require 'json-schema-generator'
require 'pathname'
require 'fileutils'

cur_dir = ARGV[0]
out_dir = ARGV[1]
default_version = JSON::SchemaGenerator::DEFAULT_VERSION

options = {
    :schema_version => default_version,
    :defaults => false
}
puts "Generating json schema files from #{cur_dir} to #{out_dir}"

FileUtils.mkdir_p(out_dir)
Dir.glob(Pathname.new(cur_dir).join("*.json")) do |json_file|
  puts "Processing file #{json_file}..."
  schema = JSON::SchemaGenerator.generate json_file, File.read(json_file), options
  File.open(Pathname.new(out_dir).join(File.basename(json_file)), 'w+') do |file|
    file.write(schema)
    puts "File #{file} has been created successfully..."
  end
end


