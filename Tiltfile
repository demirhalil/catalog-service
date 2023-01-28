# Build
custom_build(
    ref = 'catalog-service',
    command = './gradlew bootBuildImage --imageName $EXPECTED_REF',
    deps = ['build.gradle', 'src']
)

k8s_yaml(['deployment/kubernetes/platform/development/deployment.yml', 'deployment/kubernetes/platform/development/service.yml'])
k8s_resource('catalog-service', port_forwards=['9001'])