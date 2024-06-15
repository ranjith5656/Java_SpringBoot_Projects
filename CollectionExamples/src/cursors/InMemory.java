//@Override
//    public void markTaskAsCompleted(Long id) {
//        Task task = taskRepository.findById(id);
//        if (task != null) {
//            task.setCompleted(true);
//            taskRepository.save(task);
//        }
//    }