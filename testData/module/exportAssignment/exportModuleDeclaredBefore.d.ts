// based on semver.d.ts
declare module SemverModule {
//...
}

//TODO: drop empty module
declare module "semver" {
    export = SemverModule;
}
