# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog].

## [v8.1.0-1.20.1] - 2023-10-27
**BREAKING UPDATE:** All diagonal connections from existing blocks will disappear. The blocks need to be replaced for them to show again.
### Changed
- No longer applies patches to vanilla blocks, instead a new custom block is dynamically added for every block that is to be made diagonal
- Players will not notice a difference as there is no new item or crafting recipe, everything works just as it did on the user-side
- Overhauled connection block state updates, recalculates changes much more efficiently now
- Performance improvements for constructing shapes
- Other blocks intersecting with a diagonal connection will now prevent it from forming
### Fixed
- Fixed block state mismatches when joining a server without the mod installed
- Fixed log spam for incompatible block state models, every block will only be logged once at most

## [v8.0.1-1.20.1] - 2023-07-19
### Fixed
- Fixed an occasional crash when reloading resources

## [v8.0.0-1.20.1] - 2023-06-27
- Ported to Minecraft 1.20.1

[Keep a Changelog]: https://keepachangelog.com/en/1.0.0/
